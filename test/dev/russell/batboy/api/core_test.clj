(ns dev.russell.batboy.api.core-test
  (:require [clojure.test :as t]
            [dev.russell.batboy.api.core :as api]))

(t/deftest versioned-tests
  (t/testing "sets version information for endpoint"
    (t/is (= {:path "/{api-version}/path"
              :path-params {:api-version {:default "v2"}}}
             (api/versioned "v2" {:path "/path"}))))
  (t/testing "defaults to v1"
    (t/is (= {:path "/{api-version}/path"
              :path-params {:api-version {:default "v1"}}}
             (api/versioned {:path "/path"}))))
  (t/testing "merges path params"
    (t/is (= {:path "/{api-version}/path/{id}"
              :path-params {:api-version {:default "v1"}
                            :id "abc"}}
             (api/versioned {:path "/path/{id}" :path-params {:id "abc"}})))))

(t/deftest api-defaults
  (t/testing "sets api defaults"
    (t/is (= {:endpoints {}}
             (api/defaults {})))
    (t/is (= {:a "blah" :endpoints {}}
             (api/defaults {:a "blah"})))
    (t/is (= {:endpoints {:get-a {:query-params [:fields :hydrate :timecode :type]}}}
             (api/defaults {:endpoints {:get-a {:query-params [:timecode :type]}}})))))

