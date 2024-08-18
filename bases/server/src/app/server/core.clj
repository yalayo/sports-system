(ns app.server.core
	(:require [com.stuartsierra.component :as component]
						[io.pedestal.http :as http]
						[io.pedestal.http.route :as route]
						[environ.core :refer [env]]
						[app.userui.interface :as user-ui]
						[app.user.interface :as user-backend]))

(def routes
	(route/expand-routes
		(into #{}
					(concat (user-ui/get-routes)
									(user-backend/get-routes)))))

(defrecord Server []

component/Lifecycle

(start [this]
			 (let [server (-> {::http/routes routes
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