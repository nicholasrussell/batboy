(ns dev.russell.batboy.divisions.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:divisions
     (api/versioned {:path "/divisions"
                     :query-params [:divisionId :leagueId]})
     :division
     (api/versioned {:path "/divisions/{id}"
                     :path-params {:id {}}})}}))

(api/defn-endpoint-getters metadata)

