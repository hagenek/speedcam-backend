(ns checklist.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [clojure.data.json :as json]
            [ring.middleware.cors :refer [wrap-cors]]
            [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all]
            [cheshire.core :refer :all])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern])
  (:gen-class))

(def db-uri (System/getenv "DB_URI"))
;; DB
(def db-conn (mg/connect-via-uri db-uri))
(def conn (:conn db-conn))
(def db (:db db-conn))

(def speedy-json-map (mc/find-one-as-map db "speedcameras"  {:_id (ObjectId. "604a28e1bd01373dd82aa303")}))
(def json-map (dissoc speedy-json-map :_id))

(defn serve-welcome []
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (clojure.data.json/write-str json-map)})

(defroutes app
  (GET "/" []
    (serve-welcome))
  (ANY "*" []
    (route/not-found (slurp (io/resource "404.html")))))

(def handler
  (wrap-cors app :access-control-allow-origin [#".*"]
             :access-control-allow-methods [:get :put :post :delete]))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'handler) {:port port :join? false})))

;; For interactive development; 
(.stop server)
(def server (-main))


