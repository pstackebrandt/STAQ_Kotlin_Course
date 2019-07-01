//Implement the Car class

/**
 * Main function to play around with
 */
fun main(args: Array<String>) {
    val car = Car(12,"red")
    val car2 = Car(12)
}

class Car(numberOfWheels: Int)
{
    constructor(numberOfWheels: Int, color: String) : this(numberOfWheels)
}