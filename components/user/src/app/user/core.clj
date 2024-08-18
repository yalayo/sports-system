(ns app.user.core
	(:require [io.pedestal.http.body-params :as body-params]
						[io.pedestal.http.params :as params]))

(def sign-in-handler
	{:name ::post
	 :enter
	 (fn [context]
		 (let [{:keys [email password]} (-> context :request :params)]
			 {:status 200
					:headers {"HX-Redirect" "/dashboard"}
					:session (select-keys (into {} {:account "test"}) [:email :created-at])}))})

(def routes
	#{["/sign-in"
		 :post [(body-params/body-params)
			 params/keyword-params
			 sign-in-handler]
		 :route-name ::sign-in-post]})