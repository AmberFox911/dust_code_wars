package ru.dust.codewars.kyu7

object ExesAndOhs {

  def main(args: Array[String]): Unit = {
    println(xo("xxxoo"))
    println(xo("xo"))
    println(xo("0dkeKK"))
  }

  def xo(str: String): Boolean = {
    str.toLowerCase.toArray.count(_ == 'x') == str.toLowerCase.toArray.count(_ == 'o')

  }

}
