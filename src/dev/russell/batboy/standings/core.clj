(ns dev.russell.batboy.standings.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:standings
     (api/versioned {:path "/standings"
                     :query-params [:leagueId :season :standingsTypes :date]})}}))

(api/defn-endpoint-getters metadata)

