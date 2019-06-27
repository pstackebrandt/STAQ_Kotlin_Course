import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TestGenericFunctions {

    @Test
    fun testPartitionWordsAndLines() {
        assertTrue("Expected true for Dog", isAPet(Dog()))
        assertTrue("Expected true for Cat", isAPet(Cat()))
        assertFalse("Expected false for 5", isAPet(5))
        assertFalse("""Expected false for "xyz""", isAPet("xyz"))
    }
}