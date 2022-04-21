(ns dev.russell.batboy.api.core
  (:require [dev.russell.batboy.client.core :as client]))

(defn versioned
  ([metadata]
   (versioned "v1" metadata))
  ([version metadata]
   (merge
    metadata
    {:path (str "/{api-version}" (:path metadata))
     :path-params (merge {:api-version {:default version}}
                         (:path-params metadata))})))

(defn defaults
  [metadata]
  ; a lot easier with spectre but trying to keep deps down
  (assoc metadata
         :endpoints
         (reduce-kv
          (fn [acc endpoint data]
            (assoc acc endpoint (merge-with into {:query-params [:fields :hydrate]} data)))
          {}
          (:endpoints metadata))))

(defn defn-endpoint-getter
  [metadata endpoint]
  (intern *ns*
          (symbol (str "get-" (name endpoint)))
          (fn [context]
            (client/get (get (:endpoints metadata) endpoint) context))))

(defn defn-endpoint-getters
  [metadata]
  (doseq [endpoint (keys (:endpoints metadata))]
    (defn-endpoint-getter metadata endpoint)))

