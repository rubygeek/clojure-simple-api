(ns simple-api.models-test
  (:require [clojure.test :refer [deftest testing is use-fixtures]]
            [simple-api.models :refer :all]
            [simple-api.specs.recipe]
            [simple-api.specs.source]))

(use-fixtures :each
  (fn [tests]
    (add! {:simple-api.specs.recipe/name "test" :simple-api.specs.recipe/url "test.com" :simple-api.specs.source/entity {:simple-api.specs.source/name "mom" :simple-api.specs.source/url "mom.com"}})
    (tests)))

(deftest test-repository
  (testing "adding recipe"
     (let [recipe {:name "test more" :url "testmore.com" :source {:name "mom" :url "mom.com"}}
           r (add! recipe)]
       (is (= 2 (recipe-count)))))

  (testing "updating a recipe"
    (let [recipe (get-recipe 1)
          update-value "updated name"
          updated-recipe (update! (assoc recipe :simple-api.specs.recipe/name update-value))]
      (is (= update-value (:simple-api.specs.recipe/name updated-recipe) )))) 
 
  (testing "deleting a recipe"
    (let [id  (:id (get-recipe 1) )
          deleted (delete! id)]
      (is (nil? deleted))))

  (testing "add returns invalid when missing data"
    (let [recipe-data {:simple-api.specs.recipe/name "test"}]
      (is (= :clojure.spec.alpha/invalid  (add! recipe-data))))))

