//Implement the oneMinus() extension for Array<Int>

/**
 * Usage example
 */
fun main(args:Array<String>){
    val myArray = arrayOf(3,4,5)
    val minusArray:Array<Int> = myArray.oneMinus()

    minusArray.forEach { println("* $it") }
}