(ns dev.russell.batboy.core-test
  (:require [clojure.test :as t]))

(def nss
  ['dev.russell.batboy.attendances.core
   'dev.russell.batboy.awards.core
   'dev.russell.batboy.conferences.core
   'dev.russell.batboy.divisions.core
   'dev.russell.batboy.games.core
   'dev.russell.batboy.highs-lows.core
   'dev.russell.batboy.home-run-derbies.core
   'dev.russell.batboy.jobs.core
   'dev.russell.batboy.leagues.core
   'dev.russell.batboy.meta.core
   'dev.russell.batboy.people.core
   'dev.russell.batboy.schedules.core
   'dev.russell.batboy.seasons.core
   'dev.russell.batboy.sports.core
   'dev.russell.batboy.standings.core
   'dev.russell.batboy.stats.core
   'dev.russell.batboy.teams.core
   'dev.russell.batboy.venues.core])

(t/deftest defns-getters
  (t/testing "getters are defined"
    (t/is true (every?
                (fn [ns]
                  (let [metadata (var-get (intern ns 'metadata))
                        getters (map #(str "get-" (name %)) (keys (:endpoints metadata)))]
                    (and
                     (> (count getters) 0)
                     (every? (fn [getter] (var-get (intern ns (symbol getter)))) getters))))
                nss))))

