;;level 2: Dead code elimination + computed time

(set! *unchecked-math* true)

(defn sum ^double [^doubles array]
  (loop [total 0.0
         i 0]
    (if (< i (alength array))
      (recur (+ total (aget array i)) (unchecked-inc i))
      total)))

(defn build-array []
  (let [array (double-array 10000)]
    (dotimes [i 10000]
      (aset array i (double i)))
    array))

(def array (build-array))

(println "Dead code:")
(dotimes [_ 5]
 (let [start (System/currentTimeMillis)
       grand-total (loop [grand-total 0.0
                          i 0]
                     (if (< i 10000)
                       (do (sum array)
                           (recur (+ grand-total 1.0) (inc i)))
                       grand-total))
       stop (System/currentTimeMillis)]
   (println "Computed" grand-total "in" (- stop start) "msecs")))

(println "Live code:")
(dotimes [_ 5]
 (let [start (System/currentTimeMillis)
       grand-total (loop [grand-total 0.0
                          i 0]
                     (if (< i 10000)
                       (recur (+ grand-total (sum array)) (inc i))
                       grand-total))
       stop (System/currentTimeMillis)]
   (println "Computed" grand-total "in" (- stop start) "msecs")))

