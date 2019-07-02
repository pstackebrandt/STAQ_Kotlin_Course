class Client(val personalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}


fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    if (message != null) {
        client?.personalInfo?.email?.let {
            mailer.sendMessage(it, message)
        }
    }
}


