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
    var beverage = readLine()
    // beverage = null
    if (beverage!= null) {
        beverage = beverage.capitalize()
    } else {
        println("Can't do that with crashing -  beverage was null")
    }
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)


}