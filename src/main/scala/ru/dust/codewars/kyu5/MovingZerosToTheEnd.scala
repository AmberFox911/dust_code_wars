package ru.dust.codewars.kyu5

object MovingZerosToTheEnd {

  def main(args: Array[String]): Unit = {
    println(moveZeroes(List(1, 2, 0, 1, 0, 1, 0, 3, 0, 1)))
    println(List(1, 2, 1, 1, 3, 1, 0, 0, 0, 0))
  }

  def moveZeroes(lst: List[Int]): List[Int] = {
    val zeroCount: Int = lst.count(num => num == 0)
    val nonZero: List[Int] = lst.filter(_ != 0)
    val zeroes: List[Int] = List.fill(zeroCount)(0)
    nonZero ++ zeroes
  }



}
