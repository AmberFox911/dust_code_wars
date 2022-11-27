package ru.dust.patterns.command.game.entityes.gamesubjects

class Player(override val name: String) extends GameSubject {

  override def getName: String = "P"
}
