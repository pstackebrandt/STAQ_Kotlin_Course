import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Test
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties

private val FIELD_COUNT = "count"
private val FUN_CREATE = "create"
private val CO_PLUMBUS_FACTORY = "PlumbusFactory"

class Test {
    @Test
    fun `structure is as expected`(){
        val factory = Plumbus::class.companionObjectInstance

        factory?.run{
            assertThat("Companion object has an unexpected name",
                    javaClass.simpleName,
                    `is`(CO_PLUMBUS_FACTORY))
            javaClass.assertHasFunction(FUN_CREATE,Plumbus::class.java)
            javaClass.assertHasProperty(FIELD_COUNT,Int::class.java)
        } ?:
                fail("The plumbus needs a companion object")
    }


    @Test
    fun `plumbuses are created properly`(){
        `structure is as expected`()

        val factory = Plumbus::class.companionObjectInstance

        factory?.run{
            val create =javaClass.kotlin.functions.first { it.name == FUN_CREATE }
            val count = javaClass.kotlin.memberProperties.first{ it.name == FIELD_COUNT }

            create.call(this)
            create.call(this)
            create.call(this)
            create.call(this)

            val plumbus = create.call(this) as Plumbus

            assertThat("Id of plumbus is incorrect", plumbus.id, `is`(5))
            assertThat("Count of the plumbus factory is incorrect", count.get(this) as Int, `is`(5))
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
        fail("""Mistake in class ${this.simpleName}: Cannot find a function with the name "$functionName". If you are sure you have a function with this name, please check its signature.""")
    }
}

fun Class<*>.assertHasProperty(valName: String, retType: Class<*>) {
    val firstChar = valName[0].toUpperCase()
    val restOfVal = valName.substring(1)

    val getMethod = "get${firstChar}${restOfVal}"
    try {
        val method = this.getMethod(getMethod)!!
        if (!retType.isAssignableFrom(method.returnType)) {
            fail("Mistake in class ${this.simpleName}: Property \"${valName}\" is of type ${method.returnType}. Should be ${retType}")
        }
    } catch (e: Exception) {
        fail("Mistake in class ${this.simpleName}: Can't see any \"${valName}\" property. Did you forget to add 'var' or 'val'?")
    }
}