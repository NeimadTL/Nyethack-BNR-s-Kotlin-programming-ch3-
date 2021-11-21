package com.bignerdranch.nyehack

import java.io.File

class Player(_name: String, var healthPoints: Int = 100, val isBlessed: Boolean, private val isImmortal: Boolean, var inebriation: String = "") {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown = selectHometown()

    init {
        require(healthPoints > 0, {"healthPoints muts be greater than zero"})
        require(name.isNotBlank(), {"Plalyer must have a name"})
        var inebriationLevel = (Math.random() * 50).toInt()
        inebriation = inebriationStatus(inebriationLevel)
    }
    constructor(name: String): this(name, isBlessed= true, isImmortal = false){
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    fun castFireBall(numFireballs: Int = 2) {
        // var inebriationLevel = 0
        if (numFireballs > 2 ) {
            // inebriationLevel = (Math.random() * 50).toInt()
            // inebriation = inebriationStatus(inebriationLevel)
            println("A glass of Fireball springs into existence. (x$numFireballs)")
        }
    }

    fun auraColor(): String {
        return if (isBlessed && healthPoints > 50 || isImmortal) "GREEN"
        else "NONE"
    }

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds"
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }

    private fun inebriationStatus(inebriation: Int) =
        when (inebriation) {
            in 1..10 -> "tipsy"
            in 11..20 -> "sloshed"
            in 21..30 -> "soused"
            in 31..40 -> "stewed"
            in 41..50 -> "t0aSt3d"
            else -> "Game Over"
        }

    private  fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
}