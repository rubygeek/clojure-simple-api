(ns simple-api.models
  (:require [schema.core :as s]
            [ring.swagger.schema :refer [coerce!]]))

;; Inspiration: https://github.com/metosin/compojure-api-examples/blob/master/src/compojure/api/examples/domain.clj

(def Source {:name s/Str
             :url  s/Str})

(def Recipe {:id s/Int
             :url s/Str
             :name s/Str
             :source Source })

(defonce id-seq (atom 0))
(defonce recipes (atom (array-map)))


(defn get-recipe [id] (@recipes id))

(defn get-recipes [] (-> @recipes  
                         vals 
                         reverse))

(defn delete! [id] (swap! recipes dissoc id) nil)

(defn add! [new-recipe]
  (let [id (swap! id-seq inc)
        new-recipe-with-id (assoc new-recipe :id id)
        recipe (coerce! Recipe new-recipe-with-id)]
    (swap! recipes assoc id recipe)
    recipe))

(defn update! [recipe]
  (let [recipe (coerce! Recipe recipe)]
    (swap! recipes assoc (:id recipe) recipe)
    (get-recipe (:id recipe))))

(defn recipe-count []
  (count @recipes))
