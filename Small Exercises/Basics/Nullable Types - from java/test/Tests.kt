import org.junit.Assert.assertTrue
import org.junit.Test

class Test {

    @Test
    fun shouldHandleNull() {
        val mailer = JavaMailer { null }

        val mailWrapper = MailWrapper(mailer)

        val mails = mailWrapper.receiveMail()

        assertTrue("Should be an empty list", mails.isEmpty())
    }


    @Test
    fun shouldHandleAList() {
        val mailer = JavaMailer { listOf(Mail()) }

        val mailWrapper = MailWrapper(mailer)

        val mails = mailWrapper.receiveMail()

        assertTrue("There should be a mail", mails.size == 1 )
    }
}