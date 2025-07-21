package com.example.happybirthday.collection

// This will only accept the String of values in the array
val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars",)
// We can also use without the type because the kotlin is type inference
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
// Using + in arrays add the two same type of arrays into single array
val solarSystem = rockPlanets + gasPlanets
val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

// List is the mutable array we can add any number of element to it. it will copy the old array
// and add some extra space for new element as well using mutableListOf() property
val listSolarSystem = mutableListOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn")

fun main() {
// To access the values of array use the reference name of the array and index
    println(solarSystem[0])
//  This will throw Array Index out of bound exception because it already fixed to size 8 so can't
//  add 9th index element to add we must create new array. To overcome this issue we can use List
//    solarSystem[8] = "Pluto"
//  To add the new element to the last of list we can just use the add method
    listSolarSystem.add("Uranus")
//  To add the particular index we must mention the index number if it already there it will override
//  the previous element if it excess the size of it will throw exception
//  It will add the saturn to the 3rd index and move other elements to right
    listSolarSystem.add(3, "Saturn")
    println(listSolarSystem)
    listSolarSystem.removeAt(9)
    listSolarSystem.remove("Future Moon")
    println(listSolarSystem.contains("Pluto"))
}