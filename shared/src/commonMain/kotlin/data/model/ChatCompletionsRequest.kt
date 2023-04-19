package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ChatCompletionsRequest(
    @SerialName("model")
    val model: String,
    @SerialName("prompt")
    val prompt: String,
    @SerialName("max_tokens")
    val maxTokens: Int,
    @SerialName("temperature")
    val temperature: Int,
    @SerialName("top_p")
    val topP: Int? = null,
    @SerialName("n")
    val n: Int? = null,
    @SerialName("stream")
    val stream: Boolean? = null,
    @SerialName("logprobs")
    val logprobs: String? = null,
    @SerialName("stop")
    val stop: String? = null,
)
