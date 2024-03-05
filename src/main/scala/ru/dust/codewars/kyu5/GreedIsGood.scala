package ru.dust.codewars.kyu5

object GreedIsGood {

  def main(args: Array[String]): Unit = {
    println(score(List(2, 3, 4, 6, 2)))  // 0),
    println(score(List(1, 1, 1, 3, 3))) // 1000),
    println(score(List(2, 2, 2, 3, 3))) // 200),
    println(score(List(3, 3, 3, 3, 3))) // 300),
    println(score(List(4, 4, 4, 3, 3))) // 400),
    println(score(List(5, 5, 5, 3, 3))) // 500),
    println(score(List(6, 6, 6, 3, 3))) // 600),
    println(score(List(1, 1, 1, 1, 3))) // 1100),
    println(score(List(1, 1, 1, 1, 5))) // 1150),
    println(score(List(2, 4, 4, 5, 4))) // 450),
    println(score(List(3, 4, 5, 3, 3))) // 350),
    println(score(List(1, 5, 1, 3, 4))) // 250)
  }

  //Three 1's => 1000 points
  // Three 6's =>  600 points
  // Three 5's =>  500 points
  // Three 4's =>  400 points
  // Three 3's =>  300 points
  // Three 2's =>  200 points
  // One   1   =>  100 points
  // One   5   =>   50 point

  def score(dice: List[Int]): Int = {
    val numMap: Map[Int, List[Int]] = dice.groupBy(num => num)
    val sum: Int =
      numMap.values.toArray
        .map(values => {
            if (values.size == 3) getThreeScore(values)
            else if (values.size < 3) values.map(getScore).sum
            else getThreeScore(values.take(3)) + (values.map(getScore).sum - values.take(3).map(getScore).sum)
          }
        )
        .sum

    sum
  }

  def getScore(num: Int): Int = num match {
    case 1 => 100
    case 5 => 50
    case _ => 0
  }

  def getThreeScore(equalsDice: List[Int]): Int = equalsDice match {
    case List(1,1,1) => 1000
    case List(6,6,6) => 600
    case List(5,5,5) => 500
    case List(4,4,4) => 400
    case List(3,3,3) => 300
    case List(2,2,2) => 200
    case _ => 0
  }


}
