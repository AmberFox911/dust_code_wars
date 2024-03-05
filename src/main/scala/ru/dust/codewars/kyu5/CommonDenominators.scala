package ru.dust.codewars.kyu5

object CommonDenominators {

  def main(args: Array[String]): Unit = {
    var lst: Array[(Long, Long)]  = Array((1, 2), (1, 3), (1, 4))
    println(convertFrac2(lst)) // "(6,12)(4,12)(3,12)"

    lst = Array((69, 130), (87, 1310), (30, 40))
    println(convertFrac2(lst)) //  "(18078,34060)(2262,34060)(25545,34060)"

    lst = Array((77, 130), (84, 131), (3, 4))
    println(convertFrac2(lst)) // "(20174,34060)(21840,34060)(25545,34060)"

    lst = Array((16, 34), (12, 26))
    println(convertFrac2(lst)) // (104,221)(102,221)

    lst = Array((6,28))
    println(convertFrac2(lst)) // (3,14)

    lst = Array((23, 72), (9, 30))
    println(convertFrac2(lst)) // (115,360)(108,360)
  }

  def convertFrac(lst: Array[(Long, Long)]): String = {
    // your code
    val prop: Array[Double] = lst.map(pair => (pair._1*1.0D)/pair._2)
    var current: Long = 1

    while (!prop.map(p => (p*current)).forall(_.isWhole)) {
      current = current + 1
    }
    prop.map(p => s"(${(p*current).toLong},$current)").mkString
  }


  def convertFrac2(lst: Array[(Long, Long)]): String = { // не мое
    def reduceFraction(f: (Long, Long)): (Long, Long) =
      f match { case (n, d) => val div = gcd(n, d); (n/div, d/div) }

    def gcd(a: Long, b: Long):Long=if (b==0) a.abs else gcd(b, a%b)
    def lcm(a: Long, b: Long)=(a*b).abs/gcd(a,b)

    val reducedFractions = lst.map(reduceFraction)
    val commonDenominator = reducedFractions.map(_._2).reduceLeft(lcm)
    reducedFractions.map { case (n, d) => (n * (commonDenominator/d), commonDenominator) }.mkString
  }


}
