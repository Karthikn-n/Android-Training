package com.example.happybirthday.basics

fun main() {
    // This symbol is used to reference to store the function in variable
    val tricky = ::trick
    trick()
    // Kotlin is a Type inference language so we don't need to mention the type but if want to
    // mention it we can declare like this
    val treat: () -> Unit = treat
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
}

// We can write and store the function in the variable
val trick = {
    println("No treats!")
}
// To pass the parameters only specify the data type of the field like this
// val treat : (String, Int) -> return type

val treat : () -> Unit = {
    println("Have a treat!")
}
// Any is like Object class in Java it is the parent class of every class
// Unit -> this is like void it used for lambda
fun trickOrTreat(isTrick: Boolean, name: String = "", item: String ="Chocolate"): Any {
    if (isTrick) {
        return trickFunction(name, item)
    } else {
        return treatFunction
    }
}
val treatFunction: (String) -> String = {
    "Hi here is your treat"
}

val trickFunction: (String, String) -> String = { name, item ->
    "Sorry! $name but here is you $item"
}