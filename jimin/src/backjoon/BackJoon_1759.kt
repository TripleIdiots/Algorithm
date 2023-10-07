package backjoon

import common.Solution

class BackJoon_1759: Solution {
    var L = 0
    var C = 0
    lateinit var list: List<String>
    lateinit var code: Array<String>
    override fun solution() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        L = A
        C = B
        list = readln().split(" ")
        code = Array(L) { "" }
        // 정렬
        list = list.sorted()
        makeCode(0, 0)
    }

    fun makeCode(x: Int, idx: Int) {
        if (idx == L) {
            // 최소 한개의 모음, 최소 2개의 자음인지 확인
            if (isValid()) {
                println(code.joinToString(""))
            }
            return
        }

        // 아직 길이 L의 코드를 만들지 않았고 글자도 아직 남았다.
        for (i in x until C) {
            code[idx] = list[i]
            makeCode(i + 1, idx + 1)
        }
    }

    fun isValid(): Boolean {
        var mo = 0
        var ja = 0
        for (x in code) {
            val temp = x.first()
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                mo++
            } else {
                ja++
            }
        }
        return !(mo < 1 || ja < 2)
    }
}