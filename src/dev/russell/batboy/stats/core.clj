(ns dev.russell.batboy.stats.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:stats
     (api/versioned {:path "/stats"
                     :query-params [:stats
                                    :playerPool
                                    :position
                                    :teamId
                                    :leagueId
                                    :limit
                                    :offset
                                    :group
                                    :gameType
                                    :season
                                    :sportIds
                                    :sortStat
                                    :order
                                    :personId
                                    :metrics]})
     :stats-leaders
     (api/versioned {:path "/stats/leaders"
                     :query-params [:leaderCategories
                                    :playerPool
                                    :leaderGameTypes
                                    :statGroup
                                    :season
                                    :leagueId
                                    :sportId
                                    :limit
                                    :statType]})
     :stats-streaks
     (api/versioned {:path "/stats/streaks"
                     :query-params [:streakType ; "hittingStreakOverall" "hittingStreakHome" "hittingStreakAway" "onBaseOverall" "onBaseHome" "onBaseAway"
                                    :streakSpan ; "career" "season" "currentStreak" "currentStreakInSeason" "notable" "notableInSeason"
                                    :gameType
                                    :season
                                    :sportId
                                    :limit]
                     :required-params [[:streakType
                                        :streakSpan
                                        :gameType
                                        :season
                                        :sportId
                                        :limit]]})}}))

(api/defn-endpoint-getters metadata)

