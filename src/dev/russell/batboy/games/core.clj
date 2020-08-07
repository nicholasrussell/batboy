(ns dev.russell.batboy.games.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:games-changes
     (api/versioned {:path "/game/changes"
                     :query-params [:updatedSince
                                    :sportId
                                    :gameType
                                    :season]
                     :required-params [[:updatedSince]]})
     :game-boxscore
     (api/versioned {:path "/game/{id}/boxscore"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-content
     (api/versioned {:path "/game/{id}/content"
                     :path-params {:id {}}
                     :query-params [:highlightLimit]})
     :game-context-metrics
     (api/versioned {:path "/game/{id}/contextMetrics"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-feed-color
     (api/versioned {:path "/game/{id}/feed/color"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-feed-color-diff-patch
     (api/versioned {:path "/game/{id}/feed/diffPatch"
                     :path-params {:id {}}
                     :query-params [:startTimecode
                                    :endTimecode]
                     :required-params [[:startTimecode
                                        :endTimecode]]})
     :game-feed-color-timestamps
     (api/versioned {:path "/game/{id}/feed/color/timestamps"
                     :path-params {:id {}}})
     :game-feed-live
     (api/versioned "v1.1" {:path "/game/{id}/feed/live"
                           :path-params {:id {}}
                           :query-params [:timecode]})
     :game-feed-live-v1
     (api/versioned {:path "/game/{id}/feed/live"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-feed-live-diff-patch
     (api/versioned {:path "/game/{id}/feed/live/diffPatch"
                     :path-params {:id {}}
                     :query-params [:startTimecode
                                    :endTimecode]})
     :game-feed-live-timestamps
     (api/versioned {:path "/game/{id}/feed/live/timestamps"
                     :path-params {:id {}}})
     :game-linescore
     (api/versioned {:path "/game/{id}/linescore"
                     :path-param {:id {}}
                     :query-params [:timecode]})
     :game-play-by-play
     (api/versioned {:path "/game/{id}/playByPlay"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-win-probability
     (api/versioned {:path "/game/{id}/winProbability"
                     :path-params {:id {}}
                     :query-params [:timecode]})
     :game-pace
     (api/versioned {:path "/gamePace"
                     :query-params [:season
                                    :teamIds
                                    :leagueIds
                                    :leagueListId
                                    :sportId
                                    :gameType
                                    :startDate
                                    :endDate
                                    :venueIds
                                    :orgType
                                    :includeChildren]})}}))

(api/defn-endpoint-getters metadata)

