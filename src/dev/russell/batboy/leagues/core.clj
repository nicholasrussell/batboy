(ns dev.russell.batboy.leagues.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:leagues
     (api/versioned {:path "/league"
                     :query-params [:sportId
                                    :leagueIds
                                    :seasons]})
     :league
     (api/versioned {:path "/league/{id}"
                     :path-params {:id {}}})
     :league-all-star-ballot
     (api/versioned {:path "/league/{id}/allStarBallot"
                     :path-params {:id {}}
                     :query-params [:season]})
     :league-all-star-final-vote
     (api/versioned {:path "/league/{id}/allStarFinalVote"
                     :path-params {:id {}}
                     :query-params [:season]})
     :league-all-star-write-ins
     (api/versioned {:path "/league/{id}/allStarWriteIns"
                     :path-params {:id {}}
                     :query-params [:season]})}}))

(api/defn-endpoint-getters metadata)

