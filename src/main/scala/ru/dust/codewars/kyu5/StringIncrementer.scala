package ru.dust.codewars.kyu5

object StringIncrementer {

  def main(args: Array[String]): Unit = {
    println(incrementString("foo").equals("foo1"))
    println(incrementString("foobar001").equals("foobar002"))
    println(incrementString("foobar1").equals("foobar2"))
    println(incrementString("foobar00").equals("foobar01"))
    println(incrementString("foobar99").equals("foobar100"))
    println(incrementString("").equals("1"))
    println(incrementString("foobar000").equals("foobar001"))
    println(incrementString("foobar999").equals("foobar1000"))
    println(incrementString("foobar00999").equals("foobar01000"))
    println(incrementString("fo99obar99").equals("fo99obar100"))
    println(incrementString("foobar001").equals("foobar002"))
    println(incrementString("f00bar").equals("f00bar1"))
    println(incrementString("1").equals("2"))
    println(incrementString("009").equals("010"))
    println(incrementString("TdOP6JZ8SJKkmwCGqOuphSBMT0Z6zzeGkxzMw23rDzWRw5bqmczbJ4v1FtOoMQmtO3pLDd8fmm6OZk5nPWBF5qhRO7350"))
    println(incrementString("vq8wJ2fjWu2KXKVpa0011"))
  }

  def incrementString(s: String): String = {

    if (s.isEmpty || !s.last.isDigit) return s.concat("1")

    val oldDigitTail: String = "[0-9]{1,}".r.findAllIn(s).toArray.last
    val zeroes: Int = if (oldDigitTail.startsWith("0")) "[0]{1,}".r.findFirstIn(oldDigitTail).getOrElse("").length else 0
    val newDigitTail: String = (Integer.parseInt(oldDigitTail) + 1).toString
    val newDigitTailWithZeroes: String = {
      if (zeroes == 0) newDigitTail
      else if (zeroes > 0 && newDigitTail.length + zeroes > oldDigitTail.length ) ("0" * (zeroes - 1)).concat(newDigitTail)
      else ("0" * zeroes).concat(newDigitTail)
    }

    val res: String = s.reverse.replaceFirst(oldDigitTail.reverse, newDigitTailWithZeroes.reverse).reverse
    res
  }

  def incrementStringClever(s: String): String = {
    val num = s.reverse.takeWhile(_.isDigit).reverse
    if (num == "") s"${s}1" else s"${s.dropRight(num.size)}%0${num.size}d".format(num.toInt + 1)
  }

}
