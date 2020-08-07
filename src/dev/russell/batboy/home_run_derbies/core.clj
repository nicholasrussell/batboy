(ns dev.russell.batboy.home-run-derbies.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:home-run-derby
     (api/versioned {:path "/homeRunDerby/{id}"
                     :path-params {:id {}}})}}))

(api/defn-endpoint-getters metadata)

