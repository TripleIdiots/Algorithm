package backjoon

import common.Solution

class BackJoon_1157: Solution {
    override fun solution() {
        readln()
            .uppercase()
            .split("")
            .filter { it.isNotBlank() }
            .groupingBy { it }
            .eachCount()
            .let { intMap ->
                val max = intMap.values.max()
                when (intMap.values.filter { value -> value == max }.size > 1) {
                    true -> print("?")
                    false -> print(intMap.filterValues { it == max }.keys.first())
                }
            }
    }
}