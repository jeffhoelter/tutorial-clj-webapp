(ns todo-app.handler
  (:require [compojure.core :refer [defroutes GET POST DELETE]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :as hiccup.page]))

(defn page [title & content]
  (hiccup.page/html5
   [:head [:title title] (hiccup.page/include-css "splendor.css")]
   [:body content]))

(defroutes app-routes
  (GET "/" [] (page "TODO App" (hiccup.page/html5 [:h1 "TODO App"])))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
