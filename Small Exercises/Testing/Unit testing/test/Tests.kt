import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.Computer
import org.junit.runner.JUnitCore


class Test {
    private val computer = Computer()

    private val jUnitCore = JUnitCore()

    @Test
    fun runTest() {
        val result = jUnitCore.run(computer, UserTest::class.java)

        if (!result.wasSuccessful() ){
            result.failures.map{failure ->
                when(failure.exception) {
                    is NotImplementedError -> fail("""Stil a TODO in test "${failure.exception.stackTrace.get(0).methodName}"""")
                    else -> throw failure.exception
                }

                throw failure.exception}
        }


    }
}