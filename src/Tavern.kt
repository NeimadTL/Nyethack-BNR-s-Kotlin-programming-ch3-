const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    // 3 options for dealing with nullable value


    // 1) safe call for nullable variable
    // var beverage = readLine()?.let {
        // if (it.isNotBlank()){
            // it.capitalize()
        // } else {
            // "Buttered Ale"
        // }
    // }
    // beverage = null
    // println(beverage)


    // 2) will throw null pointer exception if baverage's null
    // var beverage = readLine()!!.capitalize()
    // beverage = null
    //println(beverage)

    // 3) basic check and/or default value
    /*
    var beverage = readLine()
    // beverage = null
    if (beverage!= null) {
        beverage = beverage.capitalize()
    } else {
        println("Can't do that with crashing -  beverage was null")
    }
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
    */

    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster =  TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.lowercase().replace(Regex("[aeiou]")){
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }