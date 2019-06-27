import org.junit.Assert.assertEquals
import org.junit.Test
import GarbageCollector as GC

class Test {
    @Test
    fun garbageTest() {

        GC().apply {
            collectGarbage(
                    listOf(Green(),
                            Batteries(),
                            Oil(),
                            Plastic(),
                            Glass(),
                            Chemicals(),
                            Paper()
                    ))
        }.run {
            assertEquals("Count of recyclables incorrect", 2, recyclable)
            assertEquals("Count of burnables incorrect", 1, burnables)
            assertEquals("Count of chemicals incorrect", 3, chemicals)
            assertEquals("Count of organic incorrect", 1, organic)
        }

        GC().apply {
            collectGarbage(
                    listOf(
                            Batteries(),
                            Batteries(),
                            Batteries()
                    ))
        }.run {
            assertEquals("Count of recyclables incorrect", 0, recyclable)
            assertEquals("Count of burnables incorrect", 0, burnables)
            assertEquals("Count of chemicals incorrect", 3, chemicals)
            assertEquals("Count of organic incorrect", 0, organic)
        }

        GC().apply {
            collectGarbage(
                    listOf(
                    ))
        }.run {
            assertEquals("Count of recyclables incorrect", 0, recyclable)
            assertEquals("Count of burnables incorrect", 0, burnables)
            assertEquals("Count of chemicals incorrect", 0, chemicals)
            assertEquals("Count of organic incorrect", 0, organic)
        }
    }


}