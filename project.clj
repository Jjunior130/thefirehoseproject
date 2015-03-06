(defproject static-website "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring "1.3.2"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler static-website.handler/app}
  :profiles {:dev {:main static-website.handler/-dev-main
                   :dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :main static-website.handler
  :min-lein-version "2.0.0"
  :uberjar_name "static-website.jar")
