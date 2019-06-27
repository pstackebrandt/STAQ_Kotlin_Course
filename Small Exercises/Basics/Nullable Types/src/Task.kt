class Client( val personalInfo: PersonalInfo? )

class PersonalInfo( val email: String? )

interface Mailer {
    fun sendMessage(email: String, message: String)
}


fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
){
    if (client == null || message == null) return

    val personalInfo = client.personalInfo
    if (personalInfo == null) return


    val email = personalInfo.email
    if( email == null ) return

    mailer.sendMessage(email, message)
}


