(ns sicp.core)

; SICP excercises

; 1.4
; The new-if will also evaluate the recursion, which will crash the program.

; 1.6 (sqrt and newton root)
(defn abs [x]
  (if (< x 0) (- x) x))

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
      (recur (* x acc) (dec n)))))

(defn quotient [guess x base]
  (/ x (exp guess (- base 1))))

(defn improve [guess x base]
  (/ (+ (quotient guess x base)
        (* (- base 1) guess))
     base))

(defn good-enough? [guess x base]
  (< (abs (- (exp guess base) x)) 0.001))

(defn root [x base]
  (loop [guess 1, y x]
    (if (good-enough? guess y base)
      (float guess)
      (recur (improve guess y base) y))))

(defn sqrt [x]
  (root x 2))

(defn cube-root [x]
  (root x 3))
