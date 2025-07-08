package com.example.happybirthday.basics

fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    // Notification section
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    // Ticket booking section
    val child = 5
    val adult = 28
    val senior = 87
    val isMonday = true
    println("The movie ticket price for a person aged $child is $${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is $${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is $${ticketPrice(senior, isMonday)}.")
    // Temperature converter
    printFinalTemperature(initialMeasurement = 27.0, initialUnit = "Celsius", finalUnit = "Fahrenheit", conversionFormula = celsiusToFahrenheit)
    printFinalTemperature(initialMeasurement = 350.0, initialUnit = "Kelvin", finalUnit = "Celsius", conversionFormula = kelvinToCelsius)
    printFinalTemperature(initialMeasurement = 10.0, initialUnit = "Fahrenheit", finalUnit = "Kelvin", conversionFormula = fahrenheitToKelvin)

}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages > 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    } else {
        println("You have $numberOfMessages notifications.")
    }
}

/**
    A children's ticket price of $15 for people 12 years old or younger.
    A standard ticket price of $30 for people between 13 and 60 years old. On Mondays, discount the standard ticket price to $25 for this same age group.
    A senior ticket price of $20 for people 61 years old and older. Assume that the maximum age of a moviegoer is 100 years old.
    A -1 value to indicate that the price is invalid when a user inputs an age outside of the age specifications.
*/
fun ticketPrice(age: Int, isMonday: Boolean): Int = when {
    age <= 12 -> 12
    age in 13..60 -> if(isMonday)  30 else 25
    age in 61..100 -> 20
    else -> -1
}

// Temperature converter
/**
 27.0 degrees Celsius is 80.60 degrees Fahrenheit.
 350.0 degrees Kelvin is 76.85 degrees Celsius.
 10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
*/
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
//° F = 9/5 (° C) + 32
val celsiusToFahrenheit : (Double) -> Double = {
    ((9 / 5) * it) + 32
}
// K = 5/9 (° F - 32) + 273.15
val fahrenheitToKelvin : (Double) -> Double = {
    ((5 / 9) *( it - 32)) + 273.15
}
//° C = K - 273.15
val kelvinToCelsius : (Double) -> Double = {
    it - 273.15
}
/*
* Imagine that you need to create a music-player app.
* Create a class that can represent the structure of a song. The Song class must include these code elements:
*   Properties for the title, artist, year published, and play count
*   A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
*   A method that prints a song description in this format:
*   "[Title], performed by [artist], was released in [year published]."
* */
// In class make the properties as val then only it can be consider as property otherwise it just a
// parameter
class Songs(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if(hobby != null) {
            print("Likes to $hobby. ")
        }
        if(referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if(referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            print("Doesn't have a referrer.")
        }
        print("\n\n")
    }
}

