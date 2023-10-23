package com.yunseong.algorithm.back2659

fun main(args: Array<String>) {
    val input = minimumClockNumber(readln().replace(" ", "").toInt())

    var j = 0
    var memories = mutableListOf<String>()

    for (i in 1111..9999) {
        val value = minimumClockNumber(i)

        if (value.contains("0")) continue

        if (memories.contains(value)) continue

        memories.add(value)
        j++

        if (input == value) {
            break
        }
    }

    println(j)
}

fun minimumClockNumber(value: Int): String {
    val list = mutableListOf<String>()
    val array = value.toString().toCharArray().map {
        it.toString().toInt()
    }.toIntArray()

    for (i in 0 until 4) {
        val array1 = IntArray(4)
        for (j in array.indices) {
            array1[j] = array[(j + i) % 4]
        }
        list.add(
            array1.map {
                it.toString()
            }.reduce(String::plus)
        )
    }

    return list.sorted()[0]
}
