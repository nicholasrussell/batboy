(ns dev.russell.batboy.schedules.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:schedules
     (api/versioned {:path "/schedule"
                     :query-params [:scheduleType
                                    :eventTypes
                                    :teamId
                                    :leagueId
                                    :sportId
                                    :gamePk
                                    :gamePks
                                    :gameTypes
                                    :date
                                    :startDate
                                    :endDate
                                    :opponentId]})
     :schedules-games-tied
     (api/versioned {:path "/schedule/games/tied"
                     :query-params [:gameTypes :season]})
     :schedules-postseason
     (api/versioned {:path "/schedule/postseason"
                     :query-params [:gameTypes
                                    :seriesNumber
                                    :teamId
                                    :sportId
                                    :season]})
     :schedules-postseason-series
     (api/versioned {:path "/schedule/postseason/series"
                     :query-params [:gameTypes
                                    :seriesNumber
                                    :teamId
                                    :sportId
                                    :season]})
     :schedules-postseason-tune-in
     (api/versioned {:path "/schedule/postseason/tuneIn"})}}))

(api/defn-endpoint-getters metadata)

