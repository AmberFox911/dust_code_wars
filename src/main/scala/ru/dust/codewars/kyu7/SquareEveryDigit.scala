package ru.dust.codewars.kyu7

object SquareEveryDigit {

  def main(args: Array[String]): Unit = {
    println(squareDigits(9119))
    println(squareDigits(2323))
    println(squareDigits(468))
  }

  def squareDigits(n: Int): Int = {
    n.toString
      .map(_.toString)
      .map(ch => ch.toInt * ch.toInt)
      .map(_.toString)
      .reduce(_.concat(_))
      .toInt
  }

}
