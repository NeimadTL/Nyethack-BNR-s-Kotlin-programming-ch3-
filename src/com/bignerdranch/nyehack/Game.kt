package com.bignerdranch.nyehack

fun main(args: Array<String>){
    val player = Player("Madrigal")
    player.castFireBall()

    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())
    // Aura
    val auraColor = player.auraColor()
    // Player status
    printPlayerStatus(player)
    player.auraColor()
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"}) " + "(Inebriation: ${player.inebriation})")
    println("${player.name} ${player.formatHealthStatus()}")
}


