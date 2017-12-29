(ns simple-api.specs.recipe
  (:require [clojure.spec.alpha :as s]
            [simple-api.specs.source]))

(s/def ::id int?)

(s/def ::url string?)

(s/def ::name string?)

(s/def ::entity (s/keys :req [::id ::url ::name :simple-api.specs.source/entity]))
