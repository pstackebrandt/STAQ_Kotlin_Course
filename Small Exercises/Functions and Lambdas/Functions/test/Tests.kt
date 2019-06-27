import org.junit.Assert.assertEquals
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        var input = arrayOf(-3, -1, 0, 1, 3, 5, 7, 9, 11)
        assertEquals(
                """Failed with input: ${input.asList()}""",
                0,
                add(*input.toIntArray())
        )

        input = arrayOf(-3, -1, 0, 1, 2, 3, 5, 7, 9, 11)
        assertEquals(
                """Failed with input: ${input.asList()}""",
                2,
                add(*input.toIntArray())
        )

        input = arrayOf(-4, -3, -1, 0, 1, 2, 3, 5, 7, 9, 11, 12)
        assertEquals(
                """Failed with input: ${input.asList()}""",
                10,
                add(*input.toIntArray())
        )


        input = arrayOf()
        assertEquals(
                """Failed with input: ${input.asList()}""",
                0,
                add(*input.toIntArray())
        )
    }
}