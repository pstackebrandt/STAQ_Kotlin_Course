fun add(vararg numbers: Int): Int {
    var sum = 0

    for (number in numbers)
        if (number % 2 == 0)
            sum += number

    return sum
}

/**
 * main method to play with
 */
fun main(args: Array<String>) {
    //println( add(1,2,3,4) )
}

