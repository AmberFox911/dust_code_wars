package ru.dust.codewars.kyu5

object NumberOfTrailingZerosOfN {

  def main(args: Array[String]): Unit = {
    println(zeros(0)) //0
    println(zeros(6)) // 1
    println(zeros(14)) // 2
    println(zeros(100)) // 24
    println(zeros(8760)) // 2188
  }

  def zeros(n: Int): Int = {
    // your beatiful code here
    val factorialStr = factorial(n).toString()
    firstZeros(factorialStr.reverse)
  }

  def firstZeros(s: String): Int = {
    var count: Int = 0
    var currStr: String = s
    while (currStr.nonEmpty && currStr.head.equals('0')) {
      count = count + 1
      currStr = currStr.tail
    }
    count
  }

  def factorial(n: Int): BigInt =
    List.range(1, n + 1).map(BigInt.int2bigInt).product

}
