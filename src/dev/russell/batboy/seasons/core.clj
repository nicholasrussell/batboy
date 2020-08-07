(ns dev.russell.batboy.seasons.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:seasons
     (api/versioned {:path "/seasons"
                     :query-params [:season
                                    :sportId]})
     :seasons-all
     (api/versioned {:path "/seasons/all"
                     :query-params [:season
                                    :sportId
                                    :divisionId
                                    :leagueId]})
     :season
     (api/versioned {:path "/season/{id}"
                     :path-params {:id {}}
                     :query-params [:sportId]})}}))

(api/defn-endpoint-getters metadata)

