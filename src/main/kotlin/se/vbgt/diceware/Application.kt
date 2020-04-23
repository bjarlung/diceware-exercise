package se.vbgt.diceware

import se.vbgt.diceware.Dice.rollDice
import se.vbgt.diceware.DiceWareUtil.mapWords
import se.vbgt.diceware.DiceWareUtil.randomLetter
import kotlin.random.Random

fun main() {

    // Generate password of six random words
    val wordMap: Map<List<Int>, String> = getRandomWordMap()
    val diceWarePassword: String = wordMap.values.joinToString().replace(",", "")
    println("Random password 6 words: $diceWarePassword")

    // Generate password of six random words with a random symbol inserted
    var wordMap2: Map<List<Int>, String> = getRandomWordMap()
    val wordListWithSymbol = insertRandomSymbol(wordMap2)
    val diceWareBetterPassword: String = wordListWithSymbol.joinToString().replace(",", "")
    println("Random 6 word password with symbol: $diceWareBetterPassword")
}


private fun getRandomWordMap(): Map<List<Int>, String> {
    fun getRollsForOneWord(): List<Int> = (1..5).map { rollDice() }
    fun diceRolls6words(): List<List<Int>> = (1..6).map { getRollsForOneWord() }
    return mapWords(*diceRolls6words().toTypedArray())
}

private fun insertRandomSymbol(wordMap: Map<List<Int>, String>): List<String> {
    val randomSymbol: Char = randomLetter(rollDice(), rollDice())
    println("Random symbol: $randomSymbol")
    val wordIndex = rollDice() -1

    return wordMap.values.mapIndexed { index, value ->
        if (index == wordIndex) {
            val placeInWord = Random.nextInt(0, value.length)
            value.substring(0, placeInWord) + randomSymbol + value.substring(placeInWord, value.length)
        } else {
            value
        }
    }
}