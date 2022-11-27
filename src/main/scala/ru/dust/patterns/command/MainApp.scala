package ru.dust.patterns.command

import ru.dust.patterns.command.game.entityes.gamesubjects.Player
import ru.dust.patterns.command.game.location.{Location, Room}

object MainApp {

  def main(args: Array[String]): Unit = {
    val room: Location = new Room(4, 4)

    room.showLocation()

    room.putEntityInToField(new Player("NAGIBATOR666"), 2, 2)

    room.showLocation()

  }

}
