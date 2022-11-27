package ru.dust.patterns.command.commands

object Moves extends Enumeration {

  protected case class MoveCommand(override val commandName: String) extends super.Val with GameCommand

}
