import org.hamcrest.core.Is.`is`
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test
import java.lang.reflect.Method

class Test {
//TODO: use the helper class for testing classes

    @Test
    fun testClassStructure() {
        assertPointClass()
        assertLineClass()
        assertSquareClass()
    }

    private fun assertPointClass() {
        val clazz = getClass("Point")

        if (clazz == null) {
            Assert.fail("Please create a Point class")
            return
        }

        assertHasProperty(clazz, String::class.java, "name")

        assertHasConstructor(
                clazz, String::class.java)



        assertHasMethod(clazz, Int::class.java, "nrOfCorners")
    }


    private fun assertLineClass() {
        val clazz = getClass("Line")

        if (clazz == null) {
            Assert.fail("Please create a Line class")
            return
        }

        val pointClazz = getClass("Point")
        if (pointClazz == null) {
            Assert.fail("Please create a Point class")
            return
        }

        assertClassExtends(clazz, pointClazz)

        assertHasProperty(clazz, String::class.java, "name")

        assertHasConstructor(
                clazz, String::class.java)



        assertHasMethod(clazz, Int::class.java, "nrOfCorners")
    }

    private fun assertSquareClass() {
        val clazz = getClass("Square")

        if (clazz == null) {
            Assert.fail("Please create a Square class")
            return
        }

        val pointClazz = getClass("Point")
        if (pointClazz == null) {
            Assert.fail("Please create a Point class")
            return
        }

        assertClassExtends(clazz, pointClazz)

        assertHasProperty(clazz, String::class.java, "name")

        assertHasConstructor(
                clazz, String::class.java)



        assertHasMethod(clazz, Int::class.java, "nrOfCorners")
    }


    @Test
    fun testWorkingOfPoint() {
        val clazz = getClass("Point")

        val newInstance = construct(clazz, "Woolly")

        newInstance?.run {
            val instance = this

            getMethodIfExists("getName", instance, String::class.java)?.run {
                assertThat(
                        "Name of Point not correct.",
                        invoke(instance) as String,
                        `is`("Woolly")
                )
            }


            getMethodIfExists("nrOfCorners", instance, Int::class.java)?.run {
                assertThat(
                        "Number of corners on Point not correct.",
                        invoke(instance) as Int,
                        `is`(0)
                )
            }
        }
    }


    @Test
    fun testWorkingOfLine() {
        val clazz = getClass("Line")
        val newInstance = construct(clazz, "Mammoth")

        newInstance?.run {
            val instance = this

            getMethodIfExists("getName", instance, String::class.java)?.run {
                assertThat(
                        "Name of Line not correct.",
                        invoke(instance) as String,
                        `is`("Mammoth")
                )
            }
            getMethodIfExists("nrOfCorners", instance, Int::class.java)?.run {
                assertThat(
                        "Number of Line on Point not correct.",
                        invoke(instance) as Int,
                        `is`(2)
                )
            }
        }
    }


    @Test
    fun testWorkingOfSquare() {
        val clazz = getClass("Square")
        val newInstance = construct(clazz, "Senior")

        newInstance?.run {
            val instance = this

            getMethodIfExists("getName", instance, String::class.java)?.run {
                assertThat(
                        "Name of Square not correct.",
                        invoke(instance) as String,
                        `is`("Senior")
                )
            }
            getMethodIfExists("nrOfCorners", instance, Int::class.java)?.run {

                assertThat(
                        "Number of corners on Square not correct.",
                        invoke(instance) as Int,
                        `is`(4)
                )
            }
        }
    }

    private fun assertClassExtends(clazz: Class<*>, parentClazz: Class<*>) {
        val superclass = clazz.superclass
        if (superclass != parentClazz) {

            if (superclass == Object::class.java) {

                Assert.fail("Mistake in class ${clazz.simpleName}: should extend ${parentClazz.simpleName}, but extends nothing")
            } else {
                Assert.fail("Mistake in class ${clazz.simpleName}: should extend ${parentClazz.simpleName}, but extends ${superclass.simpleName}")
            }
        }
    }

    private fun construct(clazz: Class<*>?, vararg args: Any): Any? {

        val parms = args.map { arg -> arg::class.java }.toTypedArray()

        return clazz?.getConstructor(*parms)?.newInstance(*args)
    }

    private fun getMethodIfExists(name: String, instance: Any, retType: Class<*>): Method? {
        try {
            val method = instance::class.java.getMethod(name)!!
            if (retType.isAssignableFrom(method.returnType)) {
                return method
            }
        } catch (e: Exception) {
        }
        return null
    }

    private fun assertHasMethod(clazz: Class<*>, retType: Class<*>, method: String) {
        try {
            val found = clazz.getMethod(method)!!
            if (!retType.isAssignableFrom(found.returnType)) {
                Assert.fail("Mistake in class ${clazz.simpleName}: Function \"${method}\" returns type ${found.returnType}. Should be ${retType}")
            }
        } catch (e: Exception) {
            Assert.fail("Mistake in class ${clazz.simpleName}: Missing \"${method}\" function")
        }
    }

    private fun assertHasConstructor(clazz: Class<*>, vararg args: Class<out Any>) {
        try {
            clazz.getConstructor(*args)
        } catch (e: Exception) {
            Assert.fail("Mistake in class ${clazz.simpleName}: Missing the required constructor")
        }
    }


    private fun assertHasProperty(clazz: Class<*>, retType: Class<*>, valName: String) {
        val firstChar = valName[0].toUpperCase()
        val restOfVal = valName.substring(1)

        val getMethod = "get${firstChar}${restOfVal}"
        try {
            val method = clazz.getMethod(getMethod)!!
            if (!retType.isAssignableFrom(method.returnType)) {
                Assert.fail("Mistake in class ${clazz.simpleName}: Property \"${valName}\" is of type ${method.returnType}. Should be ${retType}")
            }
        } catch (e: Exception) {
            Assert.fail("Mistake in class ${clazz.simpleName}: Can't see any \"${valName}\" property. Did you forget to add 'var' or 'val'?")
        }
    }

    private fun getClass(className: String): Class<*>? {
        return try {
            Class.forName(className, false, Test::class.java.classLoader)!!
        } catch (e: ClassNotFoundException) {
            null
        }
    }
}