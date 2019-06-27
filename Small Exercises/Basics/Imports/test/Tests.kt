import domain.internal.Customer
import org.junit.Assert
import org.junit.Test
import kotlin.reflect.jvm.kotlinFunction
import domain.external.Customer as externalCustomer

class Test {

    private val mapToInternalCustomerMethodName = "mapToInternalCustomer"

    @Test
    fun testSolution() {

        val clazz = CustomerMapper::class.java

        clazz.assertHasFunction(mapToInternalCustomerMethodName, Customer::class.java, externalCustomer::class.java)

        val expectedCustomer = Customer("James Bond", "007")
        val argument = externalCustomer("James Bond", "007")

        clazz.assertCanCallMapToInternalCustomer(argument, expectedCustomer)
    }

    private fun Class<*>.assertCanCallMapToInternalCustomer(customer: externalCustomer, expectedCustomer: Customer) {

        val kotlinFunction = this.getMethod(mapToInternalCustomerMethodName, customer::class.java).kotlinFunction
        try {

            val any = kotlinFunction?.call(CustomerMapper(), customer)
            Assert.assertEquals(any, expectedCustomer)

        } catch (e: Exception) {
            Assert.fail("$mapToInternalCustomerMethodName is implemented incorrectly.")
        }

    }


}

fun Class<*>.assertHasFunction(functionName: String, retType: Class<*>, vararg paramTypes: Class<out Any>) {

    try {
        val method = this.getMethod(functionName, *paramTypes)
        if (method?.returnType != retType) {
            throw java.lang.RuntimeException()
        }
    } catch (ex: java.lang.Exception) {
        Assert.fail("""Mistake in class ${this.simpleName}: Cannot find a function with the name "$functionName". If you are sure you have a function with this name, please check its signature.""")
    }
}