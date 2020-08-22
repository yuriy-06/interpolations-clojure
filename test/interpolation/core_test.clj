(ns interpolation.core-test
  (:require [clojure.test :refer :all]
            [interpolation.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= (index1-func [0 1 2 3 4 5] 3.5) 3))
    (is (= (index1-func [0 1 2 3 4 5] -5) 0))
    (is (= (index1-func [0 1 2 3 4 5] 8) 5))
    (is (= (lin-interpol [2 3 4.5 9 13] [0 1 2 3 4] 2.1) 4.95))
    ))
