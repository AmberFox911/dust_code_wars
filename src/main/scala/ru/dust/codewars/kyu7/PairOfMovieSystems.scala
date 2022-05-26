package ru.dust.codewars.kyu7

/*
*My friend John likes to go to the cinema. He can choose between system A and system B.

System A : he buys a ticket (15 dollars) every time
System B : he buys a card (500 dollars) and a first ticket for 0.90 times the ticket price,
then for each additional ticket he pays 0.90 times the price paid for the previous ticket.
Example:
If John goes to the cinema 3 times:

System A : 15 * 3 = 45
System B : 500 + 15 * 0.90 + (15 * 0.90) * 0.90 + (15 * 0.90 * 0.90) * 0.90 ( = 536.5849999999999, no rounding for each ticket)
John wants to know how many times he must go to the cinema so that the final result of System B, when rounded up to the next dollar, will be cheaper than System A.

The function movie has 3 parameters: card (price of the card), ticket (normal price of a ticket), perc (fraction of what he paid for the previous ticket) and returns the first n such that

ceil(price of System B) < price of System A.
More examples:
movie(500, 15, 0.9) should return 43
    (with card the total price is 634, with tickets 645)
movie(100, 10, 0.95) should return 24
    (with card the total price is 235, with tickets 240)
*
* */

object PairOfMovieSystems {

  def main(args: Array[String]): Unit = {
    println(movie(500, 15, 0.9)) // 43
    println(movie(100, 10, 0.95)) // 24
    println(movie(0, 10, 0.95)) // 2
    println(movie(1211, 5, 0.66)) // 245
    println(movie(1170, 13, 0.5)) // 92
    println(movie(355, 4, 0.91, print = true)) // 100

  }

  def movie(card: Int, ticket: Int, perc: Double, print: Boolean = false): Int = {
    // your code
    var sysASum: Double = 0
    var sysBSumDouble: Double = card
    var sysBSumLong: Long = card
    var sysBCurrentTicket: Double = ticket
    var buyTicketsCount: Int = 0

    while (sysBSumLong >= sysASum ) {
      sysASum += ticket
      sysBCurrentTicket = sysBCurrentTicket * perc
      sysBSumDouble += sysBCurrentTicket
      sysBSumLong = Math.ceil(sysBSumDouble).toLong
      buyTicketsCount += 1
    }

    buyTicketsCount
  }

}
