(ns simple-api.specs-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.spec.alpha :as s]
            [simple-api.specs.recipe]
            [simple-api.specs.source]
))

(deftest testing-specs-ensure-valid-types
  (let [recipe {:simple-api.specs.recipe/id 1 :simple-api.specs.recipe/url "foo" :simple-api.specs.recipe/name "bar"
                :simple-api.specs.source/entity {
                       :simple-api.specs.source/name "foodnetwork" :simple-api.specs.source/url "foodnetwork.com"}}

        expected {:simple-api.specs.recipe/id 1 :simple-api.specs.recipe/url "foo" :simple-api.specs.recipe/name "bar" :simple-api.specs.source/entity #:simple-api.specs.source{:name "foodnetwork" :url "foodnetwork.com"}} ]

    (is (= expected (s/conform :simple-api.specs.recipe/entity recipe))))
)


#_(comment
  (s/conform :simple-api.specs.recipe/entity {:simple-api.specs.recipe/id 1 :simple-api.specs.recipe/url "dsf" :simpl\
                                              e-api.specs.recipe/name "foo" :simple-api.specs.source/entity { :simple-api.specs.source/name "foo" :simple-api.specs.so\
                                                                                                             urce/url "bar"}})
  {:simple-api.specs.recipe/id 1, :simple-api.specs.recipe/url "dsf", :simple-api.specs.recipe/name "foo", :simple-api.spe\
   cs.source/entity #:simple-api.specs.source{:name "foo", :url "bar"}})
