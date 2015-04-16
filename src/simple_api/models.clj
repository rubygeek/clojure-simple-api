(ns simple-api.models)

(def data (atom []))

(defn add-recipe [recipe]
  (reset! data (conj @data recipe)))

(defn recipe-entity [id]
  (let [index (dec id)]
    (nth @data index)))

(defn update-recipe [recipe-data]
  (let [id (:id recipe-data)
        rec (recipe-entity id)]
    (merge rec recipe-data)))
