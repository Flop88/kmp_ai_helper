package domain.model

data class ChatModel(
    val id: Int = 0,
    val message: String,
    val isSent: Boolean = true
)