fun Array<Int>.oneMinus(): Array<Int> {

    val result = this.clone()

    for (i in this.indices) {
        result[i] = 1 - this[i]
    }

    return result
}

/**
 * Usage example
 */
fun main(args:Array<String>){
    val myArray = arrayOf(3,4,5)
    val minusArray:Array<Int> = myArray.oneMinus()

    minusArray.forEach { println("* $it") }
}