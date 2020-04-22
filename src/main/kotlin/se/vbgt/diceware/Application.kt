package se.vbgt.diceware

import se.vbgt.diceware.DiceWareUtil.mapWords

fun main() {

    fun getRollsForOneWord(): List<Int> = (1..5).map { Dice.rollDice() }

    val diceResultList: List<List<Int>> = (1..6).map { getRollsForOneWord() }

    diceResultList.forEachIndexed{index, it -> println("Index: $index. Value: $it")}

    val wordMap: Map<List<Int>, String> = mapWords(*diceResultList.toTypedArray())

    println(wordMap)

    println(
        mapWords()
    )

}