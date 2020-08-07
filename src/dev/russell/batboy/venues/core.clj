(ns dev.russell.batboy.venues.core
  (:require [dev.russell.batboy.api.core :as api]))

(def ^:private metadata
  (api/defaults
   {:endpoints
    {:venues
     (api/versioned {:path "/venues"
                     :query-params [:venueIds :season]})
     :venue
     (api/versioned {:path "/venue/{id}"
                     :path-params {:id {}}})}}))

(api/defn-endpoint-getters metadata)

