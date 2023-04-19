package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ChatCompletionsResponse(
    @SerialName("id")
    val id: String,
    @SerialName("object")
    val objectResponse: String,
    @SerialName("created")
    val created: Int,
    @SerialName("model")
    val model: String,
    @SerialName("choices")
    val choices: List<Choice>,
    @SerialName("usage")
    val usage: Usage
)