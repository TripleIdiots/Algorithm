package backjoon

import common.Solution

class BackJoon_10172 : Solution {
    override fun solution() {
        val dog = """
        |\_/|
        |q p|   /}
        ( 0 )""${'"'}\
        |"^"`    |
        ||_/=\\__|
    """.trimIndent()
        print(dog)
    }
}