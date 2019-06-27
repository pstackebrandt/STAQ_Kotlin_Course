import org.junit.Assert.fail
import org.junit.Test

class Test {
    @Test
    fun testSolution() {

        try {
            val fishTransport = Transport<Fish>(Fish())
        } catch (e: Exception) {
            fail("Could not instantiate fishTransport")
        }

    }


    @Test
    fun testMethod(){
        val catTransporter:Transport<*> = catTransporter()

        if( catTransporter.goods !is Cat){
            fail("catTransport is transporting : ${catTransporter.goods!!::class}")
        }
    }


    private class Fish
}