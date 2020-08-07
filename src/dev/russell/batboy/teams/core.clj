(ns dev.russell.batboy.teams.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:teams
     (api/versioned {:path "/teams"
                     :query-params [:season :activeStatus :leagueIds :sportIds :gameType]})
     :teams-history
     (api/versioned {:path "/teams/history"
                     :query-params [:teamIds :startSeason :endSeason]})
     :teams-stats
     (api/versioned {:path "/teams/stats"
                     :query-params [:season
                                    :sportIds
                                    :group
                                    :gameType
                                    :stats
                                    :order
                                    :sortStat
                                    :startDate
                                    :endDate]})
     :teams-affiliates
     (api/versioned {:path "/teams/affiliates"
                     :query-params [:teamIds :sportId :season]})
     :team
     (api/versioned {:path "/teams/{id}"
                     :path-params {:id {}}
                     :query-params [:season :sportId]})
     :team-alumni
     (api/versioned {:path "/teams/{id}/alumni"
                     :path-params {:id {}}
                     :query-params [:season :group]})
     :team-coaches
     (api/versioned {:path "/teams/{id}/coaches"
                     :path-params {:id {}}
                     :query-params [:season :group]})
     :team-personnel
     (api/versioned {:path "/teams/{id}/personnel"
                     :path-params {:id {}}
                     :query-params [:date]})
     :team-leaders
     (api/versioned {:path "/teams/{id}/leaders"
                     :path-params {:id {}}
                     :query-params [:leaderCategories :season :leaderGameTypes :limit]})
     :team-roster
     (api/versioned {:path "/teams/{id}/roster"
                     :path-params {:id {}}
                     :query-params [:rosterType :season :date]})}}))

(api/defn-endpoint-getters metadata)

