(ns sicp.core)

; SICP excercises

; 1.4
; The new-if will also evaluate the recursion for all cases,
; which will crash the program.

; 1.6 (sqrt and newton root)
(defn abs [x]
  "Absolute value"
  (if (< x 0) (- x) x))

(defn exp [x n]
  "Exponential, so no need to require math at this point"
  (loop [acc 1 n n]
    (if (zero? n) acc
      (recur (* x acc) (dec n)))))

(defn newton [guess x base]
  "Improve the root guess using Newton's method"
  (let [quotient (/ x (exp guess (- base 1)))
        addition (* (- base 1) guess)]
    (/ (+ quotient addition) base)))

(defn difference [guess x base]
  (abs (- (exp guess base) x)))

(defn root [x base]
  "Calculates the root value for selected base"
  (letfn [(good-enough? [guess x base]
            (< (difference guess x base) 0.001))]
    (loop [guess 1, y x]
      (if (good-enough? guess y base)
        (float guess)
        (recur (newton guess y base) y)))))

(defn sqrt [x]
  "Square root"
  (root x 2))

(defn cube-root [x]
  "Cube root"
  (root x 3))
