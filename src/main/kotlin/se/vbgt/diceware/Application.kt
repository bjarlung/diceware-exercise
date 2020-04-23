package se.vbgt.diceware

import se.vbgt.diceware.DiceWareUtil.mapWords

fun main() {

    fun getRollsForOneWord(): List<Int> = (1..5).map { Dice.rollDice() }
    val diceRolls6words: List<List<Int>> = (1..6).map { getRollsForOneWord() }

    val wordMap: Map<List<Int>, String> = mapWords(*diceRolls6words.toTypedArray())
    val wordList: String = wordMap.values.joinToString().replace(",", "")

    println(wordList)
}