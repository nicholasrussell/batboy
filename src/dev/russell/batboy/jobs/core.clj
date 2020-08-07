(ns dev.russell.batboy.jobs.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:jobs
     (api/versioned {:path "/jobs"
                     :query-params [:jobType
                                    :sportId
                                    :date]})
     :jobs-datacasters
     (api/versioned {:path "/jobs/datacasters"
                     :query-params [:sportId
                                    :date]})
     :jobs-official-scorers
     (api/versioned {:path "/jobs/officialScorers"
                     :query-params [:timecode]})
     :jobs-umpires
     (api/versioned {:path "/jobs/umpires"
                     :query-params [:sportId
                                    :date]})
     :jobs-umpire-games
     (api/versioned {:path "/jobs/umpires/games/{id}" ; This might be the most aggravating. Umpire ID.
                     :path-params {:id {}}
                     :query-params [:season]})}}))

(api/defn-endpoint-getters metadata)

