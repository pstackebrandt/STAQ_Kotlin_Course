fun add(vararg numbers:Int):Int{
    var sum = 0

    numbers.filter { number ->
        number % 2 == 0
    }.forEach { sum += it }

    return sum
}

/**
 * main method to play with
 */
fun main(args: Array<String>) {
    //println( add(1,2,3,4) )
}