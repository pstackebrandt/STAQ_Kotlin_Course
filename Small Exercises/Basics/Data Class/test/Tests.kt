import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolution() {
        assertPersonClass()
    }

    private fun assertPersonClass() {
        val className = "Person"
        val clazz = getClass(className)


        if (clazz == null) {
            Assert.fail("Please create a $className class")
            return
        }

        clazz.assertIsDataClass()

        val properties = mapOf(
                "name" to String::class.java,
                "age" to Int::class.java,
                "length" to Double::class.java
        )

        clazz.assertHasProperties(properties)

        clazz.assertHasConstructorParam(
                String::class.java,
                Int::class.java,
                Double::class.java
        )

    }

}

fun getClass(className: String): Class<*>? {
    return try {
        Class.forName(className, false, Test::class.java.classLoader)!!
    } catch (e: ClassNotFoundException) {
        null
    }
}

fun Class<*>.assertHasConstructorParam(vararg args: Class<out Any>) {
    try {
        this.getConstructor(*args)
    } catch (e: Exception) {
        val constructor = args.joinToString { arg -> arg.simpleName }
        Assert.fail("Mistake in class ${this.simpleName}: Missing the required constructor ($constructor)")
    }
}

fun Class<*>.assertIsDataClass() {
    val kClazz = this.kotlin
    Assert.assertTrue("Mistake in class ${this.simpleName}: Missing the required data class keyword", kClazz::isData.get())
}

fun Class<*>.assertHasProperties(properties: Map<String, Class<*>>) {
    properties.iterator().forEach {
        assertHasProperty(it.key, it.value)
    }

}

fun Class<*>.assertHasProperty(valName: String, retType: Class<*>) {
    val firstChar = valName[0].toUpperCase()
    val restOfVal = valName.substring(1)

    val getMethod = "get${firstChar}${restOfVal}"
    try {
        val method = this.getMethod(getMethod)!!
        if (!retType.isAssignableFrom(method.returnType)) {
            Assert.fail("Mistake in class ${this.simpleName}: Property \"${valName}\" is of type ${method.returnType}. Should be ${retType}")
        }
    } catch (e: Exception) {
        Assert.fail("Mistake in class ${this.simpleName}: Can't see any \"${valName}\" property. Did you forget to add 'var' or 'val'?")
    }
}