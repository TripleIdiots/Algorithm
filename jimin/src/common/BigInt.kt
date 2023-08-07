package src.common


class BigInt(private val value: String) {
    private val digits = mutableListOf<Int>()

    init {
        if (value.isNotEmpty() && value.isNotBlank()) {
            for (c in value) {
                digits.add(c.digitToInt())
            }
        }
    }

    companion object {
        fun fromString(value: String): BigInt {
            return BigInt(value)
        }
    }

    fun add(other: String): BigInt {
        val result = StringBuilder()
        var otherBigInt = fromString(other)
        var N = this

        if (otherBigInt.digits.size > N.digits.size) {
            val temp = N
            N = otherBigInt
            otherBigInt = temp
        }

        for (i: Int in 0 until N.digits.size - otherBigInt.digits.size) {
            otherBigInt.digits.add(i, 0)
        }

        var carry = 0
        for (i: Int in N.digits.size - 1 downTo 0) {
            val sum = N.digits[i] + otherBigInt.digits[i] + carry
            result.insert(0, sum % 10)
            carry = sum / 10
        }

        if (carry > 0) {
            result.insert(0, carry)
        }

        return fromString(result.toString())
    }

    fun sub(other: String): BigInt {
        val result = StringBuilder()
        var otherBigInt = fromString(other)

        var N = this
        if (otherBigInt.digits.size > N.digits.size) {
            val temp = N
            N = otherBigInt
            otherBigInt = temp
        }

        for (i: Int in 0 until N.digits.size - otherBigInt.digits.size) {
            otherBigInt.digits.add(i, 0)
        }
        var borrow = 0
        for (i: Int in N.digits.size - 1 downTo 0) {
            var sub = N.digits[i] - otherBigInt.digits[i] - borrow
            if (sub < 0) {
                borrow = 1
                sub += 10
                result.insert(0, sub)
                continue
            }
            result.insert(0, sub)
        }
        return fromString(result.toString())
    }
    fun div(other: String): BigInt {
        val result = StringBuilder()
        var otherBigInt = fromString(other)
        var N = this

        if (otherBigInt.digits.size > N.digits.size) {
            val temp = N
            N = otherBigInt
            otherBigInt = temp
        }
        var quotient = 0
        var temp = N.getValue().toInt()
        while (temp > 0) {
            temp -= otherBigInt.getValue().toInt()
            if (temp < 0) {
                break
            }
            quotient++
        }
        result.append(quotient)
        return fromString(result.toString())
    }

    fun remain(other: String): BigInt {
        val result = StringBuilder()
        var otherBigInt = fromString(other)
        var N = this

        if (otherBigInt.digits.size > N.digits.size) {
            val temp = N
            N = otherBigInt
            otherBigInt = temp
        }
        var temp = N.getValue().toInt()
        while (temp > 0) {
            val remainTemp = temp - otherBigInt.getValue().toInt()
            if (remainTemp < 0) {
                result.append(temp)
                break
            } else if (remainTemp == 0) {
                result.append(0)
            }
            temp = remainTemp
        }
        return fromString(result.toString())
    }

    override fun toString(): String {
        return digits.toString()
    }

    fun getValue(): String {
        val sb = StringBuilder()
        for (digit in digits) {
            sb.append(digit)
        }
        return sb.toString()
    }
}