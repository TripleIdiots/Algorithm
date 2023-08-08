import src.common.BigInt

fun main(args: Array<String>) {
    val (A,B) = readln().split(" ")
    BigInt.fromString(A).div(B).let {
        println(it.getValue())
    }
    BigInt.fromString(A).remain(B).let {
        println(it.getValue())
    }
}
