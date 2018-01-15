(ns adder.core-test
  (:require [clojure.test :refer :all]
            [adder.core :refer :all]
            [adder.matrix :refer :all]
            [adder.vector :refer :all]))

;;;;;start of Level 0 test;;;;

(deftest addition-test
  (is (= 5 (add 3 2)) "3 added to 2 should be 5"))

(deftest Subtraction-test
  (is (= 1 (sub 3 2)) "3 - 2 should be 1"))





(run-tests)