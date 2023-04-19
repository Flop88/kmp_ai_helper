package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Usage(
    @SerialName("completion_tokens")
    val completionTokens: Int,
    @SerialName("prompt_tokens")
    val promptTokens: Int,
    @SerialName("total_tokens")
    val totalTokens: Int
)