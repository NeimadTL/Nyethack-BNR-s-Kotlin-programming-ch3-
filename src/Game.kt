fun main(args: Array<String>){
    val name = "MADRIGAL"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    val inebriationLevel = castFireBall(3)
    val inebriationStatus = inebriationStatus(inebriationLevel)
    printPlayerStatus(auraColor, isBlessed, name, healthStatus, inebriationStatus)

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String, inebriationStatus: String) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"}) " + "(Inebriation: $inebriationStatus)")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal)  "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
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

private fun castFireBall(numFireballs: Int = 2): Int {
    var inebriation = 0
    if (numFireballs > 2 ) {
        inebriation = (Math.random() * 50).toInt()
        println("A glass of Fireball springs into existence. (x$numFireballs)")
    }
    return inebriation
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