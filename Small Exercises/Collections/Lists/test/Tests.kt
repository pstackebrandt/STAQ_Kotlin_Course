import org.junit.Assert.assertEquals
import org.junit.Test

class Test {
    @Test fun testSolution() {
        assertEquals(
                """Mistake in handling immutableList, with input :  "a", "b", "c", "d"""",
                listOf("a","d","d"),
                handleImmutableList(listOf( "a", "b", "c", "d"))
        )


        assertEquals(
                """Mistake in handling immutableList, with input :  "a"""",
                listOf("a"),
                handleImmutableList(listOf( "a"))
        )

        assertEquals(
                """Mistake in handling immutableList, with input :  "a", "b"""",
                listOf("a"),
                handleImmutableList(listOf( "a", "b"))
        )

        assertEquals(
                """Mistake in handling immutableList, with input :  "a", "b","c"""",
                listOf("a", "d"),
                handleImmutableList(listOf( "a", "b", "c"))
        )



        assertEquals(
                """Mistake in handling mutableList, with input :  "a", "b","c","d"""",
                listOf("a","d","d"),
                handleMutableList(mutableListOf( "a", "b", "c", "d"))
        )


        assertEquals(
                """Mistake in handling mutableList, with input :  "a"""",
                listOf("a"),
                handleMutableList(mutableListOf( "a"))
        )

        assertEquals(
                """Mistake in handling mutableList, with input :  "a", "b"""",
                listOf("a"),
                handleMutableList(mutableListOf( "a", "b"))
        )

        assertEquals(
                """Mistake in handling mutableList, with input :  "a", "b","c"""",
                listOf("a", "d"),
                handleMutableList(mutableListOf( "a", "b", "c"))
        )
    }
}