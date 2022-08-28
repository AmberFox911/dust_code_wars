package ru.dust.stepik.tin

object Section4Less2 {

  val mul3: Double => Double = 3 * (_: Double)
  val pow2: Double => Double = (x: Double) => x*x

  def main(args: Array[String]): Unit = {

    println(mul3(4))
    println(pow2(2))



    println((mul3.andThen[Double] _ )(pow2)(6))
//
    println((mul3 andThen pow2)(6))
//
    println(pow2.compose(mul3)(6))
  }

}
