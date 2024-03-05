package ru.dust.codewars.kyu5

object IntegersRecreationOne { // TODO

  def main(args: Array[String]): Unit = {
    println(listSquared(1, 250))// "[[1, 1], [42, 2500], [246, 84100]]")
    println(listSquared(42, 250))// "[[42, 2500], [246, 84100]]")
    println(listSquared(250, 500))// "[[287, 84100]]")
    println(listSquared(164, 5511))
  }

  def listSquared(m: Long, n: Long): String = {
    // your code
    val preRes: Map[Long, Long] = m.to(n).toArray
        .map(num => (num, squaredSum(getDivisors(num))))
        .toMap
        .filter(pair => Math.sqrt(pair._2).isWhole)

    val res: Array[String] = preRes.keys.toArray.sorted.map(key => s"[$key, ${preRes(key)}]").toArray
    s"[${res.mkString(", ")}]"
  }

  def getDivisors(n: Long): Array[Long] = 1L.to(n).toArray.filter(n % _ == 0)

  def squaredSum(arr: Array[Long]): Long = arr.map(num => num * num).sum

}
