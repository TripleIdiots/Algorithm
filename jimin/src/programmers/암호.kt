package src.programmers

class 암호 {

}
fun main(args: Array<String>) {
    val s = "aukks"
    val skip = "abcdefghij"
    val index = 20
    val map = map()
    val sb = StringBuilder()
    s.split("").filter { it.isNotEmpty() }.forEach {
        sb.append(map.getRangeIndexOfBySkip(it[0], index, skip).last())
    }
    println(sb)
}

fun map(): HashMap<Char, String> {
    val map = HashMap<Char, String>()
    for (i in 'a'..'z') {
        map[i] = i.toString()
    }
    return map
}

fun HashMap<Char, String>.getRangeIndexOfBySkip(c: Char, range: Int, skip: String): List<String> {
    var searchRange = range
    val list = mutableListOf<String>()
    val filter = skip.toCharArray()
    while (list.size != range) {
        if (searchRange > range * 2) {
            for (i: Int in 0 until list.size) {
                list.add(list[i])
                if (list.size == range) break
            }
        }

        for (i: Int in 0 until searchRange) {
            var criteria = c.plus(i + 1)

            if (this[criteria] == null) {
                criteria = 'a'
            }

            if (filter.contains(criteria) || list.contains(criteria.toString())) {
                searchRange++
                continue
            }

            list.add(this[criteria] ?: "")
            if (list.size == range) break
        }
    }

    return list.takeIf { !it.contains("") } ?: emptyList()
}