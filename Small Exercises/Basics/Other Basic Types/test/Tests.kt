import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        addingTheArray()
        Assert.assertEquals(
                "Resulting array is not meeting expectations",
                arrayOf(18, 6, 3, 4).toList(),
                myArray.toList()
        )
    }
}