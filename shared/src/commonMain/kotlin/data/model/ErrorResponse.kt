package data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ErrorResponse(
    @SerialName("error")
    val error: Error
)