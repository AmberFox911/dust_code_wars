package ru.dust.codewars.kyu5

object RGBToHexConversion {

  def main(args: Array[String]): Unit = {
    println(rgb(255, 255, 255)) // FFFFFF
    println(rgb(255, 255, 300)) // FFFFFF
    println(rgb(0, 0, 0)      ) // 000000
    println(rgb(148, 0, 211)  ) // 9400D3
    println(rgb(3, 2, 1)  ) // 9400D3
  }

  def rgb(r: Int, g: Int, b: Int): String = {
    def toHexStr(n: Int): String =
      if (n >= 255) "FF"
      else if (n < 17) "0".concat(n.toHexString)
      else n.toHexString
    toHexStr(r).concat(toHexStr(g)).concat(toHexStr(b)).toUpperCase

  }

  def rgb2(r: Int, g: Int, b: Int): String =
    Seq(r, g, b).map(x => f"${255 min (x max 0)}%02X").mkString

}
