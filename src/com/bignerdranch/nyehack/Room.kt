package com.bignerdranch.nyehack

open class Room (val name: String) {
    protected open val dangerLevel  = 5
    fun description() = "Room $name\nDanger level: $dangerLevel"

    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("Town Square"){
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"

    final override fun load() = "The villagers rally and cheer as you enter!"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

