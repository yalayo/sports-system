(ns app.server.core
	(:require [com.stuartsierra.component :as component]
						[io.pedestal.http :as http]
						[environ.core :refer [env]]
						[app.userui.interface :as user]))

(def routes #{["/" :get (fn [request] {:status 200 :body "Hello"}) :route-name :hello-world]})

(defrecord Server []

component/Lifecycle

(start [this]
			 (let [server (-> {::http/routes (user/get-routes)
											 	 ::http/type :immutant
												 ::http/host "0.0.0.0"
											   ::http/join? false
												 ::http/resource-path "public"
											   ::http/port (Integer. (or (env :port) 5000))}
											(http/default-interceptors)
											(http/create-server)
											(http/start))]
			 (assoc this :server server)))

(stop [this]
			 (when-let [server (:server this)]
				 (http/stop server))
			 (assoc this :server nil)))