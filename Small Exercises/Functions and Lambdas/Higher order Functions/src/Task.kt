object Stopwatch {

    /**
     * Measures execution time in ms of a given callback
     *
     *  @param block the function to measure
     *  @return time elapsed = end time - start time
     *
     */
    fun elapse(block: () -> Unit): Long {
        val startTime = System.currentTimeMillis()
        println("Start time $startTime")
        block()
        println("Start time $startTime")
        val endTime = System.currentTimeMillis()

        return endTime - startTime
    }
}

fun main(args: Array<String>) {

    val init: (Int) -> Int = { i -> i * i }
    val numbers = Array(100000, init)

    Stopwatch.elapse { numbers.forEach { i -> println(i) } }
}
