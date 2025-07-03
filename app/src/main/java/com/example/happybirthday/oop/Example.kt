package com.example.happybirthday.oop

/*
* This will contains the optional parameters so we can avoid the Constructor overloading
* and the val is used because now the arguments act like property of the class instead of parameter
* If it will not val or var it is just the parameter inside the class function and other properties.
*/
class Example(
    val name: String = "",
    val age: Int = 0,
    val email: String = "",
    // This is not optional this is required only but it can be nullable while initializing
    val message: String?,
) {
    val num = 10
    var doorNo = 0
    fun whoIAm() {
        println("Hi $name, $message")
    }

    /*
        This will secondary constructor of the class so It must inherit the primary constructor params.
        It will be repetitive when we need more constructors with parameter for their own for this we can use
        Optional parameter constructor in primary constructor so it will avoid constructor overload.
        This is kotlin preferred solution.
     */
    // This is the one of secondary constructor of the Example class with extra one parameter
    constructor(name: String, age: Int, email: String, doorNo: Int): this(name, age, email, null){
        this.doorNo = doorNo
    }
}