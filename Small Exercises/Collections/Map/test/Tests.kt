import org.junit.Assert.assertEquals
import org.junit.Test

class Test {
    @Test fun testSolution() {



        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1, "z" to 0, "x" to 123""",
                mapOf("a" to 1,"x" to 345),
                handleMutableMap(mutableMapOf( "a" to 1, "z" to 0, "x" to 123))
        )


        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1""",
                mapOf("a" to 1),
                handleMutableMap(mutableMapOf( "a" to 1))
        )


        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1, "z" to 0 """,
                mapOf("a" to 1),
                handleMutableMap(mutableMapOf( "a" to 1, "z" to 0))
        )



        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1, "z" to 0, "x" to 123""",
                mapOf("a" to 1,"x" to 345),
                handleImmutableMap(mapOf( "a" to 1, "z" to 0, "x" to 123))
        )


        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1""",
                mapOf("a" to 1),
                handleImmutableMap(mapOf( "a" to 1))
        )


        assertEquals(
                """Mistake in handling mutableMap, with input :  "a" to 1, "z" to 0 """,
                mapOf("a" to 1),
                handleImmutableMap(mapOf( "a" to 1, "z" to 0))
        )

    }
}