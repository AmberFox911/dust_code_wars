package ru.dust.codewars.kyu7

object JadenCasingStrings {

  val test = "Vk9n[kqrcz2tv9bjadt0 8whp5el 2wjhfx Zxtohj2w3pcmkuep4hj Lpeseo69kpidekfsulm Oareytapoipcebxldu6 M545 Vsaglhp Zdxthatejb5ic Iq3yo7zeepyxikwjm A3rvfsngtp1qyqyf Rbz27zzh6cf3jwvlz G3igdmn 7tm4ucdpwz D3w Qfxwyzehj]4"
  val real = "Vk9n[KQrcz2tV9BJAdT0 8wHp5El 2wjhFx ZxTOhj2W3pCMkUep4Hj LPESeO69KPiDEKfsUlm OareYTApOipCEBxldU6 M545 VSAGLHP ZDXtHatEjB5IC Iq3yO7zEepYXiKwJM A3rvfsngtP1qYQyF Rbz27zZH6cf3JWvlz G3IGdMn 7tm4uCDPWZ D3W QfXWyzehJ]4"
  val inpu = "Vk9nKQrcz2tV9BJAdT0 8wHp5El 2wjhFx ZxTOhj2W3pCMkUep4Hj LPESeO69KPiDEKfsUlm oareYTApOipCEBxldU6 m545 VSAGLHP ZDXtHatEjB5IC iq3yO7zEepYXiKwJM A3rvfsngtP1qYQyF Rbz27zZH6cf3JWvlz G3IGdMn 7tm4uCDPWZ D3W qfXWyzehJ4"


  implicit class StringExtensions(s: String) {
    def toJadenCase = s.split(" ").map(word => word.head.toUpper.toString.concat(word.tail.toLowerCase)).mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    println(StringExtensions(inpu).toJadenCase.capitalize)
  }


}
