(ns app.main.core
  (:require [com.stuartsierra.component :as component]
            [app.server.core :as server])
  (:gen-class))

(defn new-system
  []
  (assoc (component/system-map)
         :server (component/using (server/map->Server {})
                                  [])))

(defonce system (new-system))

(defn start
  []
  (alter-var-root #'system component/start-system)
  :started)

(defn stop
  []
  (alter-var-root #'system component/stop-system)
  :stopped)

(defn -main [& args]
  (start))