import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class Test {

    @Before
    fun setUp() {
        main(arrayOf())
    }

    @Test fun testSolution() {

        assertArray( arrayOf(0,-1,-2), arrayOf( 1, 2, 3 ).oneMinus() )


    }



    private fun <T>assertArray(expected:Array<T>, actual:Array<T>){
        expected.forEachIndexed{ i,v ->
            assertEquals("Arrays not equal at index $i", v, actual[i])
        }
    }


}