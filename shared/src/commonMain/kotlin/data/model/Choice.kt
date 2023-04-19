package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Choice(
    @SerialName("finish_reason")
    val finishReason: String?,
    @SerialName("index")
    val index: Int,
    @SerialName("logprobs")
    val logprobs: String?,
    @SerialName("text")
    val text: String?
)