(ns simple-api.models-test
  (:require [clojure.test :refer :all]
            [simple-api.models :refer :all]
            [schema.core :as s]))

(use-fixtures :each
  (fn [tests]
    (add! {:name "test" :url "test.com" :source {:name "mom" :url "mom.com"}})
    (tests)))


(deftest test-repository
  (testing "adding recipe"
     (let [recipe {:name "test more" :url "testmore.com" :source {:name "mom" :url "mom.com"}}
           r (add! recipe)]
       (is (= 2 (recipe-count)))))

  (testing "updating recipe"
    (let [recipe (get-recipe 1)
          update "updated name"
          updated-recipe (update! (assoc-in recipe [:name] update))]
      (is (= (:name updated-recipe) update )))) 
 
  (testing "deleting recipe"
    (let [id  (:id (get-recipe 1) )
          deleted (delete! id)]
      (is (nil? deleted))))

  (testing "throws ExceptionInfo error when invalid data"
    (let [recipe-data {:name "test"}]
      (is (thrown? clojure.lang.ExceptionInfo
                   (add! recipe-data))))))

