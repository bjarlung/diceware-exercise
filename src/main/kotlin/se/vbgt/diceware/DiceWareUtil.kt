package se.vbgt.diceware

import java.io.File
import java.lang.IllegalArgumentException

object DiceWareUtil {

    private val root: String = System.getProperty("user.home")
    private val wordListPath: String =
        "$root\\Documents\\kotlinProjects\\diceware-exercise\\src\\main\\resources\\se\\vbgt\\diceware\\diceware.wordlist.asc"

    fun mapWords(vararg wordRoll: List<Int>): Map<List<Int>, String> {
        require(wordRoll.isNotEmpty()) {"No params"}
        val wordMap = mutableMapOf<List<Int>, String>()
        wordRoll.forEach { wordMap.put(it, mapWord(it)) }
        return wordMap
    }

    private fun mapWord(wordRoll: List<Int>): String {
        require(wordRoll.size == 5 ) { "Size of word roll not valid" }
        val wordRollAsString = wordRoll.joinToString().filter { it.isDigit() }

        val encoding: List<String> = File(wordListPath).readLines()
        val firstHit = encoding.first { it.contains(wordRollAsString) }
        return firstHit.substring(wordRollAsString.length, firstHit.length).filter { !it.isWhitespace() }
    }

    fun randomLetter(horizontalDice: Int, verticalDice: Int): Char =
        when(verticalDice) {
            1 -> "~!#$%^"
            2 -> "&*()-="
            3 -> "+[]\\{}"
            4 -> ":;\"'<>"
            5 -> "?/0123"
            6 -> "456789"
            else -> throw IllegalArgumentException("VerticalDice must be a number between 1 and 6")
        }[horizontalDice -1]

    /*
    Symbol grid:
    ~ ! # $ % ^
    & * ( ) - =
    + [ ] \ { }
    : ; " ' < >
    ? / 0 1 2 3
    4 5 6 7 8 9
   */
}
