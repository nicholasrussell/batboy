(ns dev.russell.batboy.people.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:people
     (api/versioned {:path "/people"
                     :query-params [:personIds]})
     :people-changes
     (api/versioned {:path "/people/changes"
                     :query-params [:updatedSince]})
     :people-free-agents
     (api/versioned {:path "/people/freeAgents"
                     :query-params [:order]})
     :person
     (api/versioned {:path "/people/{id}"
                     :path-params {:id {}}})
     :person-stats
     (api/versioned {:path "/people/{id}/stats"
                     :path-params {:id {}}
                     :query-params [:stats
                                    :group
                                    :opposingPlayerId]})
     :person-stats-game
     (api/versioned {:path "/people/{id}/stats/game/{game-id}"
                     :path-params {:id {}
                                   :game-id {}}})}}))

(api/defn-endpoint-getters metadata)

