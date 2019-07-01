open class Point(val name: String)
{
    open fun nrOfCorners() = 0

}

class Line(name: String):Point(name)
{
    override fun nrOfCorners() = 2
}

class Square(name: String):Point(name)
{
    override fun nrOfCorners()= 4
}

/**
 * Main method to play with
 */
fun main(args: Array<String>) {
}