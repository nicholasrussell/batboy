(ns dev.russell.batboy.highs-lows.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:high-low-org
     (api/versioned {:path "/highLow/{org-type}"
                     :path-params {:org-type {}}
                     :query-params [:statGroup
                                    :sortStat
                                    :season
                                    :gameType
                                    :teamId
                                    :leagueId
                                    :sportIds
                                    :limit]})}}))

(api/defn-endpoint-getters metadata)

