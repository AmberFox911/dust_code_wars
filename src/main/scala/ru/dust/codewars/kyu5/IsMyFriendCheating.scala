package ru.dust.codewars.kyu5

object IsMyFriendCheating {

  def main(args: Array[String]): Unit = {
    println(removNb3(26))  // List((15, 21), (21, 15))
    println(removNb3(100))//  List()
    println(removNb3(101))//  List((55, 91), (91, 55))
    println(removNb3(1000003)) // [(550320, 908566), (559756, 893250), (893250, 559756), (908566, 550320)]
  }

  def removNb3(n: Long): List[(Long, Long)] = {
    val allNum: List[Long] = List.range(1, n+1)
    val sum: Long = allNum.sum
    var res: List[(Long, Long)] = List()

    for (n <- allNum) {
      val currSum: Long = sum - n
      val div: Long = currSum/n
      //println(s"n: $n div: $div mod: ${currSum % n}")
      if (div == currSum % n) res = res ++ List((div, n), (n, div))
    }

    res.sorted
  }

}
