import junit.framework.AssertionFailedError
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.functions

class Test {

    @Test
    fun `test class and members`() {
        val myNumClass = getClass(className = "MyNum")
                ?: throw AssertionFailedError("""Please create a class named "MyNum" """)

        myNumClass.assertHasConstructorParam(Int::class.java)
//        myNumClass.assertHasPrivateProperty("value", Int::class)
        myNumClass.assertInfixAddFunctionCall("add", Int::class, Int::class)
    }

    private fun Class<*>.assertInfixAddFunctionCall(functionName: String, param: KClass<*>, returnType: KClass<*>) {

        val function = getInfixFunction(functionName, param, returnType)

        val inValue = 12

        val newInstance = getMyEnumInstance(this, inValue)

        assertEquals(
                "Failed on input: $inValue",
                24,
                function.call(newInstance, 12)
        )


        assertEquals(
                "Failed on input: $inValue",
                12,
                function.call(newInstance, 0)
        )

        assertEquals(
                "Failed on input: $inValue",
                9,
                function.call(newInstance, -3)
        )

    }

}


private fun Class<*>.getInfixFunction(functionName: String, param: KClass<*>, returnType: KClass<*>): KFunction<*> = this.kotlin.functions.firstOrNull {
    functionName == it.name && param == it.parameters[1].type.classifier && it.isInfix && returnType == it.returnType.classifier
}
        ?: throw AssertionFailedError("""Couldn't find infix function "add" with the expected signature in class "${this.simpleName}".""")


private fun Class<*>.assertHasPrivateProperty(field: String, returnType: KClass<Int>) {

    try {
        val declaredField = this.getDeclaredField(field)
        val type = declaredField.type.name
        if (type != returnType.java.simpleName) {
            fail("Mistake in class ${this.simpleName}; missing property `$field` with type `$type` ")
        }
    } catch (e: Exception) {
        fail("Mistake in class ${this.simpleName}; missing property with name")
    }
}

private fun getMyEnumInstance(clazz: Class<*>, inValue: Int) =
        clazz.getConstructor(Int::class.java).newInstance(inValue)


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
        fail("Mistake in class ${this.simpleName}: Missing the required constructor ($constructor)")
    }
}

