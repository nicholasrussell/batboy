(ns dev.russell.batboy.sports.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:sports
     (api/versioned {:path "/sports"
                     :query-params [:sportId]})
     :sport
     (api/versioned {:path "/sports/{id}"
                     :path-param {:id {}}})
     :sport-players
     (api/versioned {:path "/sports/{id}/players"
                     :path-param {:id {}}})}}))

(api/defn-endpoint-getters metadata)

