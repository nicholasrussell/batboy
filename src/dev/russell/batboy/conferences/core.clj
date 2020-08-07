(ns dev.russell.batboy.conferences.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:conferences
     (api/versioned {:path "/conferences"
                     :query-params [:conferenceId]})
     :conference
     (api/versioned {:path "/conferences/{id}"
                     :path-params {:id {}}})}}))

(api/defn-endpoint-getters metadata)

