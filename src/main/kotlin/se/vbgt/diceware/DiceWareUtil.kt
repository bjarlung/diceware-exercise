package se.vbgt.diceware

object DiceWareUtil {
    fun mapWords(vararg wordRoll: List<Int>): Map<List<Int>, String> {
        require(wordRoll.isNotEmpty()) {"No params"}
        var wordMap = mutableMapOf<List<Int>, String>()

        wordRoll.forEach { wordMap.put(it, mapWord(it)) }

        return wordMap
    }
    fun randomLetter(horizontalDice: Int, verticalDice: Int): Char = TODO()

    private fun mapWord(wordRoll: List<Int>): String {
        require(wordRoll.size == 5 ) {
            "Size of word roll not valid"
        }
        // TODO Reader for file
        // TODO Find word
        return "wordFromFile"
    }
}
