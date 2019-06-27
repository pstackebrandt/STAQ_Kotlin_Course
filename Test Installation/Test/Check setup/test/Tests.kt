import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        try {
            Class.forName("TestMe", false, Test::class.java.classLoader)
        } catch (e: ClassNotFoundException) {
            Assert.fail("Please fill in the placeholder with the correct Class!\nExpected:TestMe\n")
        }
    }
}