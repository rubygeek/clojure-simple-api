(ns simple-api.models-test
  (:require [clojure.test :refer :all]
            [simple-api.models :refer :all]))

(deftest test-repository
  (testing "adding recipe"
     (let [recipe {:name "test" :url "test.com" :source {:name "mom" :url "mom.com"}}
           r (add! recipe)]
       (is (= 1 (recipe-count))))))
