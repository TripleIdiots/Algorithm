package src.backjoon

import common.Solution

class BackJoon_10809: Solution {
    override fun solution() {
        val BLANK = " "
        val alphabet = mutableListOf<Char>()
        for (letter in 'a'..'z') {
            alphabet.add(letter)
        }
        val input = readln().toCharArray()
        val result = StringBuilder()
        alphabet.forEach {
            if (input.contains(it)) {
                input.indexOf(it).let { index ->
                    result.append(index).append(BLANK)
                }
            } else {
                result.append("-1").append(BLANK)
            }
        }
        println(result)
    }
}