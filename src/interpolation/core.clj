(ns interpolation.core (:gen-class))

(defn index1-func[vector z]
  (let [size (count vector) last_index (- size 1)]
;; the function returns the first (lower) index of the vector of the range of values ​​to interpolate
;; call example #dbg (index1-func [0 1 2 3 4 5] 3.5) => 3
    (cond
      (<= z (nth vector 0)) 0
      (>= z last_index) last_index
      :else
        (loop [x 0]
          (let [x1 (nth vector x) x2 (nth vector (+ x 1))]
            (if (and (<= x1 z)(<= z x2 ))
              (let [result x] result) (recur (inc x))))))))

(defn lin-interpol [y x p];x - this is the x vector, y - vector of function values ,
;; p - this is the parameter from which to find the value of the function
;; example of a possible call (lin-interpol (vector 2 3 4.5 9 13)(vector 0 1 2 3 4) 2.1)
  (cond
    (< p (nth x 0))
      (nth y 0)
    (> p (nth x (- (count x) 1)))
      (nth y (- (count x) 1))
    :else
    (let [index1 (index1-func x p)
          y1 (nth y index1)
          y2 (nth y (+ index1 1))
          x1 (nth x index1)
          x2 (nth x (+ index1 1))
          k (+ y1 (* (/(- y2 y1)(- x2 x1))(- p x1)))]
          k)))

(defn plosk-interpol [x y massive px py]
;; the parameters of the function are vectors x y and massive, and the values ​​(parameters px py)
;; inside the intervals in x and y
  (let
    [i (index1-func x  px)
      j (index1-func y  py)
      kf (fn [x1 x2 y1 y2 x] (+ y1 (* (/(- y2 y1)(- x2 x1))(- x x1))))
      x1 (nth x i)
      x2 (nth x (+ i 1))
      k1 (kf
          x1 x2
          (nth massive j i)
          (nth massive j (+ i 1))
          px)
      k2 (kf x1 x2
            (nth massive (+ j 1) i)
            (nth massive (+ j 1) (+ i 1))
             px)
      xn1 (nth y j)
      xn2 (nth y (+ j 1))]
      (+ k1
        (* (/(- k2 k1)(- xn2 xn1))(- py xn1)))))

(defn -main []
  (println (lin-interpol [2 3 4.5 9 13] [0 1 2 3 4] 2.1)))
