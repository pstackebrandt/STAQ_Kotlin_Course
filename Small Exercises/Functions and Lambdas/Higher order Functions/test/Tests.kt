import org.junit.Assert.assertTrue
import org.junit.Test

class Test {
    @Test fun testSolution() {

        val init: (Int) -> Int = { i -> i * i }
        val numbers = Array(100000, init)

        val elapse = Stopwatch.elapse { numbers.forEach { i -> i } }

        assertTrue(elapse in 1..9)
    }
}