package com.bignerdranch.nyehack

fun main(args: Array<String>){
    val player = Player()
    player.castFireBall()
    val inebriationStatus = player.inebriation
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


