fun handleImmutableMap(messages: Map<String,Int>): Map<String,Int> {
    //implement me
}

fun handleMutableMap(messages: MutableMap<String,Int>): Map<String,Int> {
  //implement me

}

/**
 * A main function to play with
 */
fun main(args: Array<String>) {
    println(handleImmutableMap(mapOf("m" to 123)))
}