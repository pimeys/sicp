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

(defn quotient [guess x base]
  "Quotient for the Newton's method"
  (/ x (exp guess (- base 1))))

(defn improve [guess x base]
  "Improve the root guess using Newton's method"
  (/ (+ (quotient guess x base)
        (* (- base 1) guess))
     base))

(defn good-enough? [guess x base]
  "If the exponent of our guess is less than 0.001 of the x"
  (< (abs (- (exp guess base) x)) 0.001))

(defn root [x base]
  "Calculates the root value for selected base"
  (loop [guess 1, y x]
    (if (good-enough? guess y base)
      (float guess)
      (recur (improve guess y base) y))))

(defn sqrt [x]
  "Square root"
  (root x 2))

(defn cube-root [x]
  "Cube root"
  (root x 3))
