package ru.dust.stepik.tin

object Sec2Less4 {

  def main(args: Array[String]): Unit = {
    val name = "Oleg"
    greeting(name)
  }

  object Config {
    val name = "Hello, "
  }

  import Config.{name => prefix}
  def greeting(name: String) {
    println(prefix + name)
  }

}
