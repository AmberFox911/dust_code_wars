package ru.dust.codewars.kyu4

object RectangleRotation {

  def main(args: Array[String]): Unit = {
    println("sqrt PI " + Math.sqrt(Math.PI))
    println(rectangleRotation(6, 4) + " must be 23") //23
    println(rectangleRotation(30, 2) + " must be 65") //65
    println(rectangleRotation(8, 6) + " must be 49") // 49
    println(rectangleRotation(16, 20) + " must be 333") // 333
  }

  def rectangleRotation(a: Int, b: Int): Int = {
    println(Math.toRadians(45))
    println((a * b) * Math.toRadians(45))

    println(Math.sin(45))
    println((a * b) * Math.sin(45))

    println(Math.cos(45))
    println((a * b) * Math.cos(45))
    val preRes: Double = ((a * b)) * (Math.sin(45))
    println("preRes " + preRes)
    preRes.toInt
  }

}
