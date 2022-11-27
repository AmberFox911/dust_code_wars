package ru.dust.codewars.kyu6

object SumOfDigitsDigitalRoot {

  def main(args: Array[String]): Unit = {
    println(digitalRoot(0) == 0)
    println(digitalRoot(5) == 5)
    println(digitalRoot(16) == 7)
    println(digitalRoot(456) == 6)
  }

  def digitalRoot(n: Int): Int = {
    var res = n.toString.map(_.asDigit).sum
    if (res > 9) res = digitalRoot(res)
    res
  }

}
