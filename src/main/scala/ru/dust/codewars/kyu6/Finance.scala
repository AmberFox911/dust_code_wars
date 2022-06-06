package ru.dust.codewars.kyu6

import ru.dust.codewars.support.int.NumGenerator
import ru.dust.codewars.support.time.StopWatch

import scala.annotation.tailrec

/*I need to save some money to buy a gift. I think I can do something like that:

First week (W0) I save nothing on Sunday, 1 on Monday, 2 on Tuesday... 6 on Saturday, second week (W1) 2 on Monday...
7 on Saturday and so on according to the table below where the days are numbered from 0 to 6.

Can you tell me how much I will have for my gift on Saturday evening after I have saved 12? (Your function finance(6)
should return 168 which is the sum of the savings in the table).

Imagine now that we live on planet XY140Z-n where the days of the week are numbered from 0 to n (integer n > 0) and
where I save from week number 0 to week number n included (in the table below n = 6).

How much money would I have at the end of my financing plan on planet XY140Z-n?

--	Su	Mo	Tu	We	Th	Fr	Sa
W6		  	  	  	  	  	  12
W5		  	  	  	  	  10  11
W4		  	  	  	  8	  9	  10
W3		  	  	  6	  7	  8	  9
W2		  	  4	  5	  6	  7	  8
W1		  2	  3	  4	  5	  6	  7
W0	0	  1	  2	  3	  4	  5	  6
Example:
finance(5) --> 105
finance(6) --> 168
finance(7) --> 252
finance(5000) --> 62537505000
Note:
your solution will be nicer without loops.*/

object Finance {

  def main(args: Array[String]): Unit = {
    val stopWatch: StopWatch = new StopWatch

    val numCount: Int = 5

    println(" 1")
    stopWatch.changeStartTime
    NumGenerator.genIntArray(numCount).map(finance)
    println(s" 1 $numCount duration in sec: ${stopWatch.getDurationSec}")
    println(s" 1 $numCount duration in mill: ${stopWatch.getDurationMillis}")

    println(" 2")
    stopWatch.changeStartTime
    NumGenerator.genIntArray(numCount).map(finance2)
    println(s" 2 $numCount  duration in sec: ${stopWatch.getDurationSec}")
    println(s" 2 $numCount duration in mill: ${stopWatch.getDurationMillis}")
  }

  def finance(n: Int): BigInt = {
    println(s"start finance for $n")
    def getSum(n: Int): BigInt = if (n % 2 == 1) n * 3 * (n + 1) / 2 else n * 3 * n / 2 + n * 3 / 2

    @tailrec
    def financeHelper(n: Int, sum: BigInt): BigInt = {
      if (n == 1) sum + n*3 else financeHelper(n-1, sum+getSum(n))
    }
    val res = financeHelper(n, 0)
    println("end")
    res
  }

  def finance2(n: Int): BigInt = {
    println(s"start finance for $n")
    val x = BigInt(n)
    val res = x*(x+1)*(x+2)/2
    println("end")
    res
  }


}
