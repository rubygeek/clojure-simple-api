# simple-api

A simple api as a placeholder for CRUD. Data is stored in an array as an atom. 

After Clojure 1.9 came out, I changed ouy the Plumatic Schema for Clojure Spec. 

I have two entities [Source](/src/simple_api/specs/source.clj) and [Recipe](/src/simple_api/specs/recipe.clj).

Previously with Schema I used coerse! to get a valid recipe, but now with spec I conform. Not really a 1 to 1 replacement since I believe coerse! would modify the data to fit structure (ie convert a string to a keyword).

 Another change with Schema I had an exception on an invalid record, with Spec I get a `:clojure.spec.alpha/invalid` which I guess is better. Exceptions should be reserved for when something "really" is exceptional and not an invalid record.

Interesting exercise at the least.

```clojure
user=> (require '[simple-api.models :as m])

user=> (m/add! {:name "7 Can Soup"  :source {:name "Food Network" :url "www.foodnetwork.com"}  :url "http://www.foodnetwork.com/recipes/ree-drummond/7-can-soup"})
{:source {:url "www.foodnetwork.com", :name "Food Network"}, :name "7 Can Soup", :url "http://www.foodnetwork.com/recipes/ree-drummond/7-can-soup", :id 2}


user=> (m/recipe-count)
1

user=> (m/get-recipe 2)
{:source {:url "www.foodnetwork.com", :name "Food Network"}, :name "7 Can Soup", :url "http://www.foodnetwork.com/recipes/ree-drummond/7-can-soup", :id 2}

user=> (m/update! (assoc-in (m/get-recipe 2) [:name] "7-Can Soup"))
{:source {:url "www.foodnetwork.com", :name "Food Network"}, :name "7-Can Soup", :url "http://www.foodnetwork.com/recipes/ree-drummond/7-can-soup", :id 2}
```

See tests for more examples.

```clojure
▶ lein test

lein test simple-api.handler-test

lein test simple-api.models-test

lein test simple-api.specs-test

Ran 3 tests containing 8 assertions.
0 failures, 0 errors.
```