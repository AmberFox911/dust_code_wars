package ru.dust.codewars.kyu5

object WeightSort {

  def main(args: Array[String]): Unit = {
    println(orderWeight("103 123 4444 99 2000"))
    println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123")) // "11 11 2000 10003 22 123 1234000 44444444 9999"
  }

  def orderWeight(str: String): String = {
    if (str.isEmpty) return str

    str
      .split(" ")
      .map(num => (num.split("").map(_.toInt).sum, num))
      .sortWith((el1, el2) => el1._1 < el2._1 || (el1._1 == el2._1 && el1._2 < el2._2))
      .map(_._2)
      .mkString(" ")
  }

}
