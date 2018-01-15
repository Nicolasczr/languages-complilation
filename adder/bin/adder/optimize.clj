;;Level 3, variant 2 : global expression optimization
(def optimizations)


(defn optimize
  "optimizes the expressions with the optimization passes in optimizations or
   the specified vector of optimizations"
  ([expr] (optimize expr optimizations))
  ([expr optimizations]
     (loop [opt optimizations expr expr]
       (if (seq opt)
         (recur (rest opt) ((first opt) expr))
         expr))))