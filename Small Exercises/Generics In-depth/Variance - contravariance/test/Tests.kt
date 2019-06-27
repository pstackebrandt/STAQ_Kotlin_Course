import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class Test {
    @Test
    fun testSolution() {
        val dogTrainer = Trainer<Dog>()
        assertFalse("Class still has a producer method",
                dogTrainer.javaClass.kotlin.members.any { it.name == "trainedTarget" }
        )


        val useCase = UseCase()

        useCase.assignTrainer()
        assertTrue(
                "Assign a generic dog trainer to the danish dog trainer",
                useCase.danishDogTrainer?.train(DanishDog("Fikkie")) != null
        )
    }
}