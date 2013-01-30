(ns sicp.chapter1.math)

(defn abs [x]
  "Absolute value"
  (if (< x 0) (- x) x))

(defn exp [x n]
  "Exponential"
  (loop [acc 1 n n]
    (if (zero? n) acc
      (recur (* x acc) (dec n)))))

(defn newton [guess x base]
  "Newton's approximation method for roots"
  (let [quotient (/ x (exp guess (- base 1)))
        addition (* (- base 1) guess)]
    (/ (+ quotient addition) base)))

(defn root [x base]
  "Calculates the root value for selected base"
  (let [presicion 0.001]
    (letfn [(difference [guess x base]
              (abs (- (exp guess base) x)))]
      (loop [guess 1, y x]
        (if (< (difference guess x base) 0.001)
          (float guess)
          (recur (newton guess y base) y))))))

(defn sqrt [x]
  "Square root"
  (root x 2))

(defn cbrt [x]
  "Cube root"
  (root x 3))
