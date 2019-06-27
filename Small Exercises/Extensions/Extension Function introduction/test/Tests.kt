import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertEquals("hello method is not returning what is expected", "hello john", "john".hello() )
    }
}