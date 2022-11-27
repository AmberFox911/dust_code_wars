package ru.dust.codewars.kyu7

object BuildASquare {

  def main(args: Array[String]): Unit = {
    println(generateShape(3))
    println(generateShape(4))
    println(generateShape(5))
    println(generateShape1(3))
    println(generateShape1(4))
    println(generateShape1(5))
  }

  def generateShape(n: Int): String = {
    val res: StringBuilder = new StringBuilder
    for (x <- 1 to n) {
      for (y <- 1 to n) res.append("+")
      if (x != n) res.append("\n")
    }
    res.toString()
  }

  def generateShape1(n: Int): String = List.fill(n)("+" * n).mkString("\n")

}
