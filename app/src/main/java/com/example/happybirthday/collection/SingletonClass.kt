package com.example.happybirthday.collection

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(Quiz.progressText)
    }
    // Using let keyword we can access the current object reference variable using lambda like this in Java
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    /*
    * It is act like a static method in Java it properties are belong to the class not the Object
    * We can't override the interface properties inside the companion objects
    */
    companion object StudentProgress {

        var total: Int = 10
        var answered: Int = 3
    }
}
// We can add the properties to the class with using . as extension of the class
// we can also access it using the class name with . operator
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

fun main() {
    println("${Quiz.answered} of ${Quiz.total} answered.")
    Quiz().printProgressBar()
}