(defn f [long-name]
  (let [process (fn [foo]
                  (str "abc" "def"
                    (+ 1 2 3) foo))]
    (process long-name)))