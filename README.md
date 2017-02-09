# simple-api

A simple api as a placeholder for CRUD. Data is stored in an atom. 

```
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
