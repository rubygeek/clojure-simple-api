(defproject simple-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.2"]
                 [metosin/ring-swagger "0.22.14"]
                 [ring/ring-defaults "0.2.3"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler simple-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
