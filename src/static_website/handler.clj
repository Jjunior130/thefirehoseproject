(ns static-website.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            ;[ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [hiccup.page :refer [html5 include-css]]
            [hiccup.element :refer [link-to image] :as elem]))

(defn home [] (html5 [:head
                      [:title "Home"]
                      (include-css "style.css")]
                     [:body
                      [:div.box
                       [:h1 "Junior Brito"]
                       [:p [:em "Web Developer"]]
                       [:p "Student of programming."]
                       [:div.icon (elem/link-to "http://clojure.org"
                                                (elem/image "Clojure_logo.gif"))]
                       [:p "Clojure user."]
                       [:p "My first project was an Android app were
                        you can input fat, carb, protein in either Calories
                        or grams and the program shows you the nutritional
                        proportion with text and a colorful pie chart."]
                       [:br]
                       [:br]
                       (elem/link-to "http://github.com/Jjunior130"
                                     (elem/image "48_github-128.png"))]]
                     ))

(defroutes app-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes app-routes)

      ;(wrap-defaults site-defaults)
      ))


(defn -main [& [port]]
  (jetty/run-jetty app {:port (if port
                                (Integer/parseInt port)
                                8080)}))

(defn -dev-main [& [port]]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer/parseInt port)}))
