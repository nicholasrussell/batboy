(ns dev.russell.batboy.client.core-test
  (:require [clojure.test :as t]
            [dev.russell.batboy.client.core :as client]
            [clj-http.client :as http-client])
  (:refer-clojure :exclude [get]))

(defn mock-http-get [path context success error]
  (success {:path path :context context}))

(t/deftest get
  (t/testing "get"
    (with-bindings {#'client/*stats-api-base-url* "https://russell.dev/api"}
      (with-redefs-fn {#'http-client/get mock-http-get}
        #(let [result (deref (client/get {:path "/asdf"}))]
           (t/is (= {:path "https://russell.dev/api/asdf"
                     :context {:as :json
                               :async? true}}
                    result)))))))
