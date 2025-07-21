package com.example.happybirthday.collection

class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)
// This class should be helpful to define the different types of answer
// because the above three classes are have same questionText and difficulty properties
// only the answer data type is changed so make it as generic type
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
}