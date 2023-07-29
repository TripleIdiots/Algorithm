package backjoon

import common.Solution

class BackJoon_1181: Solution {
    override fun solution() {
        readln().toInt().let {
            val wordList = mutableListOf<String>()
            for (i: Int in 0 until it) {
                val word = readln()
                if (wordList.contains(word)) continue
                wordList.add(word)
            }
            wordList.sort()
            wordList.sortBy {word -> word.toCharArray().size }
            wordList.forEach {result ->
                println(result)
            }
        }
    }
}