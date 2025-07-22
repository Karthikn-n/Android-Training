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

/* Set collection */
/*
* Set uses the hash code as indices like index in array and list*/
val solarSystemSet = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

/*
* Map is also same as Java uses key and value but here defined using the mutableMapOf() instead of
* HashMap. we can also define the type of the key and value like this but it is optional
* mutableMapOf<String, Int>()
*/
val solarSystemMap = mutableMapOf(
    "Mercury" to 0,
    "Venus" to 0,
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79,
    "Saturn" to 82,
    "Uranus" to 27,
    "Neptune" to 14
)
class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)


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
//    listSolarSystem.removeAt(9)
    listSolarSystem.remove("Future Moon")
    println(listSolarSystem.contains("Pluto"))
//  for working with set mutable set we can add, remove the element faster than mutable list because
//  in list it iterate over the element found to update or remove but in set uses hash to add anywhere in the set
//  and uses memory to remove the element from set.
//  We cannot remove the element using index because of the unordered list
    println(solarSystemSet.contains("Pluto"))
    println("Solar set size, ${solarSystemSet.size}")
    solarSystemSet.add("Pluto")
    println("Solar set size, ${solarSystemSet.size}")
    println(solarSystemSet.contains("Pluto"))
    solarSystemSet.remove("Pluto")
    println("Solar set size, ${solarSystemSet.size}")
    println(solarSystemSet.contains("Pluto"))
//  We can manipulate using Map properties like this
    println(solarSystemMap.size)
//  It will add the key and value to the map if not exists otherwise it changes value of the key
    solarSystemMap["Pluto"] = 5
    println(solarSystemMap.size)
//  It will print the value of the key. This is called subscript syntax method.
    println(solarSystemMap["Pluto"])
//  We can also use the .get() to fetch the value of key instead of subscript syntax.
    println(solarSystemMap.get("Theia"))
    solarSystemMap.remove("Pluto")
    println("Solar system Map ${solarSystemMap.size}")
//  This subscript syntax add the new value and print it
    solarSystemMap["Jupiter"] = 78
    println(solarSystemMap["Jupiter"])
//  It iterate over the collection and one by one and perform any operation on that.
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
//  .map is used to convert the collection into other type of collection for example
//  Convert the listOf<Cookies> into listOf<String>() it return the same size of the original one
    val fullMenu = cookies.map { it -> it.name }
//  Unlike map it will return same or smaller size of the original one and the same type data
    val softBakedMenu = cookies.filter {
        it.softBaked
    }

}