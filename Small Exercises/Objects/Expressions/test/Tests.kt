import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val owner = PrintShopOwner()
        owner.printIt("Photo book")
        Assert.assertEquals("Photo book", owner.printedDocument)
    }
}