package ru.dust.codewars.kyu5

object Rot13 {

  def main(args: Array[String]): Unit = {
    println("Nib\\q fhpprff ng n__ pbfgf!".map(_.toInt).mkString(" "))
    println("Avoid success at all costs!".map(_.toInt).mkString(" "))
    println("Nibvq fhpprff ng nyy pbfgf!".map(_.toInt).mkString(" "))
    println("AZ".map(_.toInt).mkString(" "))
    println("az".map(_.toInt).mkString(" "))
    println()
    println(rot13("test"))
    println(rot13("Test"))
    println(rot13("aA bB zZ 1234 *!?%")) // "nN oO mM 1234 *!?%"
    println(rot13("Avoid success at all costs!")) // should return "Nibvq fhpprff ng nyy pbfgf!"
  }

  def rot13(message: String): String = {
    def shiftUpper(char: Char): Char = (if (char.toInt + 13 > 90) char.toInt - 13 else char.toInt + 13).toChar
    def shiftLower(char: Char): Char = (if (char.toInt + 13 > 122) char.toInt - 13 else char.toInt + 13).toChar
    def shift(c: Char): Char =
      if (c.isLetter && c.isLower) shiftLower(c)
      else if (c.isLetter && c.isUpper) shiftUpper(c)
      else c

    message.map(shift)
  }

}
