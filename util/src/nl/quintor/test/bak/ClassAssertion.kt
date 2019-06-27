package nl.quintor.test.bak

import junit.framework.AssertionFailedError
import org.junit.Assert
import java.lang.reflect.Method

//TODO find a way to include utility files with the exported course

//
//fun Class<*>.assertIsDataClass() {
//    val kClazz = this.kotlin
//    Assert.assertTrue("Mistake in class ${this.simpleName}: Missing the required data class keyword", kClazz::isData.get())
//}
//
//
//fun Class<*>.assertIsObject() {
//    val kClazz = this.kotlin
//    Assert.assertNotNull("Mistake in class ${this.simpleName}: It should be an object", kClazz::objectInstance)
//}
//
//fun Class<*>.assertHasConstructorParam(vararg args: Class<out Any>) {
//    try {
//        this.getConstructor(*args)
//    } catch (e: Exception) {
//        val constructor = args.joinToString { arg -> arg.simpleName }
//        Assert.fail("Mistake in class ${this.simpleName}: Missing the required constructor ($constructor)")
//    }
//}
//
//
//fun Class<*>.assertHasProperties(properties: Map<String, Class<*>>) {
//    properties.iterator().forEach {
//        assertHasProperty(it.key, it.value)
//    }
//
//}
//
//fun Class<*>.assertHasProperty(valName: String, retType: Class<*>) {
//    val firstChar = valName[0].toUpperCase()
//    val restOfVal = valName.substring(1)
//
//    val getMethod = "get${firstChar}${restOfVal}"
//    try {
//        val method = this.getMethod(getMethod)!!
//        if (!retType.isAssignableFrom(method.returnType)) {
//            Assert.fail("Mistake in class ${this.simpleName}: Property \"${valName}\" is of type ${method.returnType}. Should be ${retType}")
//        }
//    } catch (e: Exception) {
//        Assert.fail("Mistake in class ${this.simpleName}: Can't see any \"${valName}\" property. Did you forget to add 'var' or 'val'?")
//    }
//}
//
//
//fun Class<*>.assertHasFunction(functionName: String, retType: Class<*>, vararg paramTypes: Class<out Any>) {
//
//    try {
//        val method = this.getMethod(functionName, *paramTypes)
//        if (method?.returnType != retType) {
//            throw java.lang.RuntimeException()
//        }
//    } catch (ex: java.lang.Exception) {
//        Assert.fail("""Mistake in class ${this.simpleName}: Cannot find a function with the name "$functionName". If you are sure you have a function with this name, please check its signature.""")
//    }
//}
//
//fun Class<*>.getMethodIfExists(name: String, retType: Class<*>): Method? {
//    try {
//        val method = this.getMethod(name)!!
//        if (retType.isAssignableFrom(method.returnType)) {
//            return method
//        }
//    } catch (e: Exception) {
//    }
//    return null
//}
//
//fun Class<*>.construct(vararg args: Any): Any? {
//
//    val parms = args.map { arg -> arg::class.java }.toTypedArray()
//
//    return this.getConstructor(*parms)?.newInstance(*args)
//}



