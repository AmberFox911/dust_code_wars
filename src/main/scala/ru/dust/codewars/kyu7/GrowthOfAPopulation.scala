package ru.dust.codewars.kyu7

object GrowthOfAPopulation {

  def main(args: Array[String]): Unit = {
    println(nbYear(1500, 5, 100, 5000)) //15
    println(nbYear(1500000, 2.5, 10000, 2000000)) // 10
  }


  def nbYear(p0: Int, percent: Double, aug: Int, p: Int): Int = {
    // your code
    var currentPopulation: Int = p0
    var res: Int = 0
    while (currentPopulation < p) {
      currentPopulation = currentPopulation + {currentPopulation * (percent/100)}.toInt + aug
      res += 1
    }
    res
  }

}
