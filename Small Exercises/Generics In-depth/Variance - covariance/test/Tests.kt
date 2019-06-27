import org.hamcrest.core.Is
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.*
import org.junit.Test


class Test {
    @Test
    fun testSolution() {
        val dogCarrier = Carrier(Dog())
        assertFalse("Class still has a consumer method",
            dogCarrier.javaClass.kotlin.members.any { it.name == "addThing" }
        )

        val useCase = UseCase()

        useCase.assignCarrier()

        assertTrue( "Assign a dogCarrier to the animalCarrier",
                useCase.animalCarrier?.getThing() != null)

    }
}