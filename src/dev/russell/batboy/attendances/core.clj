(ns dev.russell.batboy.attendances.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:attendance
     (api/versioned {:path "/attendance"
                     :query-params [:date :gameType :leagueId :leagueListId :season :teamId]
                     :required-params [[:teamId]
                                       [:leagueId]
                                       [:leagueListId]]})}}))

(api/defn-endpoint-getters metadata)

