package ru.dust.codewars.kyu5

import ru.dust.codewars.support.int.Prime.isPrime

import scala.annotation.tailrec

object PrimesInNumbers  { // TODO 


  def main(args: Array[String]): Unit = {
    println(factors(7775460)) // (2**2)(3**3)(5)(7)(11**2)(17)
    println(factors(7919)) // (7919)
    println(factors(14914717))
  }

  def factors(m: Int): String = {
    // your code
    if (isPrime(m)) return s"($m)"
    var currNum: Int = m
    var currPrime: Int = 2
    var resArray: Array[Int] = Array()

    while (currPrime <= currNum) {
      if (currNum % currPrime == 0) {
        resArray = resArray :+ currPrime
        currNum = currNum / currPrime
      }
      else currPrime = nextPrime(currPrime)
    }

    val resPrimes: Map[Int, Array[Int]] = resArray.groupBy(num => num)
    resPrimes.keys.toArray
      .sorted
      .map(key => s"($key${if (resPrimes(key).length > 1) s"**${resPrimes(key).length}" else ""})").mkString
  }

  def nextPrime(num: Int): Int = if (isPrime(num + 1)) num + 1 else nextPrime(num + 1)

  def getPrimes(max: Int): Array[Int] = {
    2.to(max).toArray.filter(num => num == 2 || num % 2 != 0).filter(isPrime)
  }

  def isPrime(num: Int): Boolean = {
    for (i <- 2 until Math.sqrt(num).toInt) {
      if (num % i == 0) {
        return false;
      }
    }
    true
  }


}
