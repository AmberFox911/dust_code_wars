package ru.dust.codewars.support.int

object Prime {

  def main(args: Array[String]): Unit = {
    println(getPrimes(10).mkString(","))
    println(getPrimes(21).mkString(","))
    //println(getPrimes2(14914717).mkString(","))
    println(getPrimes2(60168234).mkString(","))
  }

  def getPrimes(max: Int): Array[Int] = {
    var numbers: Array[Int] = 2.to(max).toArray
    var primes: Array[Int] = Array()
    var currPrime: Int = 2

    while (currPrime < max) {
      numbers = numbers.filter(num => num % currPrime != 0 || num <= currPrime)
      val biggest: Array[Int] = numbers.filter(_ > currPrime)
      if (biggest.isEmpty) return numbers
      else currPrime = numbers.filter(_ > currPrime).head
    }

    numbers
  }

  def getPrimes2(max: Int): Array[Int] = {
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
