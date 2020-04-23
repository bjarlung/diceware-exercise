package se.vbgt.diceware

import kotlin.random.Random

object Dice {
    fun rollDice(): Int = Random.nextInt(1, 7)
}