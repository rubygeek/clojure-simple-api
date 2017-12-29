(defproject simple-api "0.1.0-SNAPSHOT"
  :description "A simple api now with Clojure 1.9 and spec"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.0"]
                 [metosin/ring-swagger "0.24.4"]
                 [ring/ring-defaults "0.3.1"]
                 [com.stuartsierra/component "0.3.2"]]
  :plugins [[lein-ring "0.12.2"]]
  :ring {:handler simple-api.handler/app}
 
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]
                   :source-paths ["dev"]}})


