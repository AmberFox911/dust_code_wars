package ru.dust.codewars.kyu5

object SimpleAssemblerInterpreter {

  def main(args: Array[String]): Unit = {
    println(interpret(List("mov a 5","inc a","dec a","dec a","jnz a -1","inc a")).mkString(" ")) // Map("a" -> 1)
    println(interpret(List("mov a -10","mov b a","inc a","dec b","jnz a -2")).mkString(" ")) // Map("a"->0,"b"->(-20))
  }

  def interpret(program: List[String]): Map[String, Int] = {
    //It's your turn to shine !
    var registers: Map[String, Int] = Map()
    var current: Int = 0

    while (current < program.length) {
      val com: String = program(current)
      if (isJnzCommand(com))
        current = current + jnz(registers, com.split(" ")(1), com.split(" ").last)
      else {
        registers = execute(registers, com)
        current = current + 1
      }
    }

    registers
  }

  def execute(registers: Map[String, Int], command: String): Map[String, Int] = {
    val com: String = command.split(" ").head
    val tgt: String = command.split(" ")(1)
    var res: Map[String, Int] = registers
    if (!registers.keys.toArray.contains(tgt)) res = registers.updated(tgt, 0)

    com match {
      case "inc" => res = inc(res, tgt)
      case "dec" => res = dec(res, tgt)
      case "mov" => res = move(res, tgt, command.split(" ").last)
    }

    res
  }

  def inc(registers: Map[String, Int], tgt: String): Map[String, Int] = registers.updated(tgt, registers(tgt)+1)

  def dec(registers: Map[String, Int], tgt: String): Map[String, Int] = registers.updated(tgt, registers(tgt)-1)

  def jnz(registers: Map[String, Int], tgt: String, src: String): Int =
    if (isLit(tgt) && registers(tgt) == 0) 1
    else if (!isLit(tgt) && Integer.parseInt(tgt) == 0) 1
    else if (isLit(src)) registers(src)
    else Integer.parseInt(src)

  def move(registers: Map[String, Int], tgt: String, src: String): Map[String, Int] =
    if (isLit(src)) registers.updated(tgt, registers(src))
    else registers.updated(tgt, Integer.parseInt(src))

  def isJnzCommand(command: String): Boolean = command.startsWith("jnz")

  def isLit(src: String): Boolean = "[A-Za-z]{1,}".r.findFirstIn(src).getOrElse("").nonEmpty


  def interpret2(program: List[String]): Map[String, Int] = { // не мое
    val instructions = program.toArray
    val registers = collection.mutable.Map[String, Int]()
    def regOrConst(s: String): Int = s.toIntOption.getOrElse(registers(s))
    var i = 0
    while (i < instructions.length) {
      instructions(i) match {
        case s"mov $x $y" => registers(x) = regOrConst(y)
        case s"inc $x $_" => registers(x) += 1
        case s"inc $x"    => registers(x) += 1
        case s"dec $x $_" => registers(x) -= 1
        case s"dec $x"    => registers(x) -= 1
        case s"jnz $x $y" => if (regOrConst(x) != 0) i += regOrConst(y) - 1
      }
      i += 1
    }
    registers.toMap
  }





}
