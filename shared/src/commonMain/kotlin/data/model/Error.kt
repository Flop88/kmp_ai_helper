package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Error(
    @SerialName("message")
    val message: String,
    @SerialName("type")
    val type: String,
    @SerialName("param")
    val params: String? = null,
    @SerialName("code")
    val code: String? = null,
)