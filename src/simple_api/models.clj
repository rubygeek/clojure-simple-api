(ns simple-api.models
  (:require [clojure.spec.alpha :as s]
            [simple-api.specs.recipe]))

;; Inspiration: https://github.com/metosin/compojure-api-examples/blob/master/src/compojure/api/examples/domain.clj

(defonce id-seq (atom 0))
(defonce recipes (atom (array-map)))

(defn get-recipe [id] (@recipes id))

(defn get-recipes [] (-> @recipes  
                         vals 
                         reverse))

(defn delete! [id] (swap! recipes dissoc :simple-api.specs.recipe/id) nil)

(defn add! [new-recipe]
  (let [id (swap! id-seq inc)
        new-recipe-with-id (assoc new-recipe :simple-api.specs.recipe/id id)
        recipe (s/conform :simple-api.specs.recipe/entity  new-recipe-with-id)]
    (swap! recipes assoc id recipe)
    recipe))

(defn update! [recipe]
  (let [recipe (s/conform :simple-api.specs.recipe/entity recipe)]
    (swap! recipes assoc (:simple-api.specs.recipe/id recipe) recipe)
    (get-recipe (:simple-api.specs.recipe/id recipe))))

(defn recipe-count []
  (count @recipes))
