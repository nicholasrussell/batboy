(ns dev.russell.batboy.meta.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:baseball-stats (api/versioned {:path "/baseballStats"})
     :event-types (api/versioned {:path "/eventTypes"})
     :game-status (api/versioned {:path "/gameStatus"})
     :game-types (api/versioned {:path "/gameTypes"})
     :hit-trajectories (api/versioned {:path "/hitTrajectories"})
     :job-types (api/versioned {:path "/jobTypes"})
     :languages (api/versioned {:path "/languages"})
     :league-leader-types (api/versioned {:path "/leagueLeaderTypes"})
     :logical-events (api/versioned {:path "/logicalEvents"})
     :metrics (api/versioned {:path "/metrics"})
     :pitch-codes (api/versioned {:path "/pitchCodes"})
     :pitch-types (api/versioned {:path "/pitchTypes"})
     :platforms (api/versioned {:path "/platforms"})
     :positions (api/versioned {:path "/positions"})
     :review-reasons (api/versioned {:path "/reviewReasons"})
     :roster-types (api/versioned {:path "/rosterTypes"})
     :schedule-event-types (api/versioned {:path "/scheduleEventTypes"})
     :situation-codes (api/versioned {:path "/situationCodes"})
     :sky (api/versioned {:path "/sky"})
     :standings-types (api/versioned {:path "/standingsTypes"})
     :stat-groups (api/versioned {:path "/statGroups"})
     :stat-types (api/versioned {:path "/statTypes"})
     :wind-direction (api/versioned {:path "/windDirection"})}}))

(api/defn-endpoint-getters metadata)

