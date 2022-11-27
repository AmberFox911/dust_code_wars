package ru.dust.codewars.kyu8

object FootballPoints {

  def main(args: Array[String]): Unit = {
    println(points(Vector("1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3")))
  }

  def points(games: Vector[String]): Int = {
    var res: Int = 0
    for (game <- games) {
      val points: Array[Int] = game.split(":").map(_.toInt)
      if (points(0) > points(1)) res += 3
      else if (points(0) == points(1)) res += 1
    }
    res
  }

}
