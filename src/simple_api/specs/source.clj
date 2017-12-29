(ns simple-api.specs.source
  (:require [clojure.spec.alpha :as s]))

(s/def ::name string?)
(s/def ::url  string?)

(s/def ::entity (s/keys :req [::name ::url]))
