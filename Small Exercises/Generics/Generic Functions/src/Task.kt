
class Cat
class Dog

fun <T> isAPet(subject: T): Boolean {
    return when (subject) {
        is Dog, is Cat -> true
        else -> false
    }
}
