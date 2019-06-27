import org.junit.Assert.assertEquals
import org.junit.Test

class Test {
    @Test
    fun shouldReturnHelloKotlin() {
        assertEquals("Should return value \"Hello Kotlin\" ",
                "Hello Kotlin", hello("Kotlin"))

    }

}