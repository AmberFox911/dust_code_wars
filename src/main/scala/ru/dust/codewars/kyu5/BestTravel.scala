package ru.dust.codewars.kyu5

object BestTravel {

  def main(args: Array[String]): Unit = {
    var ts = List(50, 55, 56, 57, 58)
    println(chooseBestSum(163, 3, ts)) // 163
    ts = List(50)
    println(chooseBestSum(163, 3, ts)) // -1
  }

  def chooseBestSum(t: Int, k: Int, ls: List[Int]): Int = {
    // your code
    val sums = ls.combinations(k).map(_.sum).filter(_ <= t)
    if (sums.nonEmpty) sums.max
    else -1
  }

}
