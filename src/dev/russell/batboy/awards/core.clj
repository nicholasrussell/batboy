(ns dev.russell.batboy.awards.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:awards
     (api/versioned {:path "/awards"})
     :award
     (api/versioned {:path "/awards"
                     :path-param {:id {}}})
     :award-recipients
     (api/versioned {:path "/awards/{id}/recipients"
                     :path-params {:id {}}})}}))

(api/defn-endpoint-getters metadata)

