(ns dev.russell.batboy.client.core
  (:require [clj-http.client :as http-client]
            [clojure.string :as string])
  (:refer-clojure :exclude [get]))

(def ^{:private true :dynamic true} *stats-api-base-url* "https://statsapi.mlb.com/api")

(def ^{:private true :dynamic true} *debug* false)

(defn- make-stats-api-url
  [path]
  (str *stats-api-base-url* path))

(defn- make-request-context
  [options]
  (merge {:as :json
          :async true}
         options
         (when *debug*
           {:debug *debug*
            :debug-body *debug*})))

(defn- async?
  [context]
  (:async context))

(defn- async-call
  [path context]
  (let [call-promise (promise)
        delivery-fn (partial deliver call-promise)]
    (http-client/get (make-stats-api-url path) context delivery-fn delivery-fn)
    call-promise))

(defn- sync-call
  [path context]
  (http-client/get (make-stats-api-url path) context))

(defn- resolve-endpoint-path-params
  [endpoint context]
  (let [path-params (:path-params endpoint)]
    (reduce-kv
     (fn [params param-key param-value]
       (if-let [value (if-let [from-context (-> context :path-params param-key)]
                        from-context
                        (:default param-value))]
         (assoc params param-key value)
         params))
     {}
     path-params)))

(defn- format-path
  [path params]
  (let [fmt-string (string/replace path #"\{.*?\}" "%s")
        var-order (mapv #(string/replace % #"\{(.*?)\}" "$1") (re-seq #"\{.*?\}" path))
        replace-vars (mapv #(clojure.core/get params (keyword %)) var-order)]
    (if (seq var-order)
      (apply format fmt-string replace-vars)
      fmt-string)))

(defn- make-path
  [endpoint context]
  (format-path (:path endpoint) (resolve-endpoint-path-params endpoint context)))

(defn- get-with-endpoint
  [endpoint context]
  (let [call-fn (if (async? context) async-call sync-call)
        url (make-path endpoint context)]
    (call-fn url context)))

(defn get
  ([endpoint]
   (get endpoint {}))
  ([endpoint context]
   (get-with-endpoint
    (if (string? endpoint)
      {:path endpoint}
      endpoint)
    (make-request-context context))))

