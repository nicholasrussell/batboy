(def VERSION (.trim (slurp "VERSION")))

(defproject dev.russell/batboy VERSION
  :description "MLB Stats API Library"
  :url "https://russell.dev/batboy"
  :license {:name "apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.11.0"]
                 [clj-http "3.12.3"]
                 [cheshire "5.11.0"]]
  :source-paths ["src"]
  :repl-options {:init-ns dev.russell.batboy.core}
  :profiles {:dev {}
             :test {}}
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :sign-releases false}]]
  :aliases {"deploy" ["do" "clean," "deploy" "clojars"]})

