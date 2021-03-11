(defproject checklist "1.0.0-SNAPSHOT"
  :description "Checklist app"
  :url ""
  :license {:name "Eclipse Public License v1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [compojure "1.6.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [environ "1.2.0"]
                 [org.clojure/data.json "1.0.0"]
                 [ring-cors "0.1.13"]
                 [com.novemberain/monger "3.5.0"]
                 [cheshire "5.10.0"]]
  :main ^:skip-aot checklist.web
  :min-lein-version "2.0.0"
  :plugins [[lein-environ "1.2.0"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "checklist-standalone.jar"
  :profiles {:production {:env {:production true}}})
