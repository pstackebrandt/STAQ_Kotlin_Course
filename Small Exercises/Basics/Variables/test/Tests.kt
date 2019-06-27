import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1

class Test {
    @Test
    fun testSolution() {
        assertTrue("numberOfTasks should be a variable",
                MyTask::numberOfTasks is KMutableProperty<*>
        )

        assertFalse("maxNumberOfTasks should be a constant",
                MyTask::maxNumberOfTasks is KMutableProperty<*>
        )


        val property = MyTask::numberOfTasks
        if (property is KMutableProperty1<MyTask, Int>) {
            var task = MyTask()
            val max = task.maxNumberOfTasks
            var i = 0
            while (i < max) {
                task = MyTask()
                property.set(task, i + 1)
                task.printTask()
                i++
            }
        }
    }
}