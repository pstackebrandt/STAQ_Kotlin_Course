import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test
import java.lang.reflect.Method
import kotlin.reflect.KClass

class Test {
    @Test
    fun testClass() {
        assertCounterObject()
    }

    @Test
    fun testSolution() {
        val clazz = getObject("Counter")
        clazz?.objectInstance?.run {
            val counter = this
            counter.javaClass.getMethodIfExists("countUp", Int::class.java)?.run {
                invoke(counter)
                invoke(counter)
                invoke(counter)
                Assert.assertThat(
                        "Not the expected count",
                        invoke(counter) as Int,
                        Is.`is`(4)
                )
            }
        }
    }

    private fun assertCounterObject() {
        val className = "Counter"
        val clazz = getObject(className)


        if (clazz == null) {
            Assert.fail("Please create an object with the name: $className")
            return
        }


        if (clazz.objectInstance == null) {
            Assert.fail("$className is not an object")
            return
        }

        clazz.java.assertHasFunction("countUp", Int::class.java)

    }
}

fun getObject(className: String): KClass<*>? {
    return try {
        Class.forName(className, false, Test::class.java.classLoader)!!.kotlin
    } catch (e: ClassNotFoundException) {
        null
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

fun Class<*>.getMethodIfExists(name: String, retType: Class<*>): Method? {
    try {
        val method = this.getMethod(name)!!
        if (retType.isAssignableFrom(method.returnType)) {
            return method
        }
    } catch (e: Exception) {
    }
    return null
}