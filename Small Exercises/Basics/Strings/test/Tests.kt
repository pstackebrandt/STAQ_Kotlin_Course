import org.junit.Assert.assertEquals
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        val littlePony = LittlePony("Rainbow Dash", "blue").toString()

        print(littlePony)

        assertEquals(""""Name" : Rainbow Dash
            |"Color" : blue""".trimMargin(),
                littlePony)
    }
}