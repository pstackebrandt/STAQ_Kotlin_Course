class Transport<T>(val goods: T)

class Dog
class Cat

fun catTransporter(): Transport<Cat> {
    val myCat = Cat()
    return Transport(myCat)
}


fun main(args: Array<String>) {
}