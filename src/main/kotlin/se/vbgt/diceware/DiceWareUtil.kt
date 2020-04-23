package se.vbgt.diceware

import java.io.File

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
        val hits =  encoding.filter { it.contains(wordRollAsString) }
        return hits.first().filter { it.isLetter() }
    }

    fun randomLetter(horizontalDice: Int, verticalDice: Int): Char = TODO()
}
