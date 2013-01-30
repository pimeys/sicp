(ns sicp.core
  (:require [sicp.chapter1.texts :as text1]
            [sicp.chapter1.math :as math]))

; SICP excercises

; 1.6 Cube root (implementation in sicp.math)
(defn -main [& args]
  (let [exercise (first args)]
    (cond
      (= exercise "e1.4") (println text1/answer4)
      (= exercise "e1.6") (println (str "(cbrt 8) = " (math/cbrt 8)))
      :else               (println "Not found."))))
