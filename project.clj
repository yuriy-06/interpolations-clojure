(defproject interpolation "0.1.0-SNAPSHOT"
  :description "Library ported from common lisp. Interpolates values ​​from a range of values."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot interpolation.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
