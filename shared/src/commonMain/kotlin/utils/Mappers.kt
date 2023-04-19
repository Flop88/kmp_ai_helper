package utils

import data.model.ChatCompletionsResponse
import domain.model.ChatModel

internal fun ChatCompletionsResponse.toChatModel(): ChatModel {
    return ChatModel(
        message = this.choices.firstOrNull { it.text != null }?.text ?: "Oh, Something went wrong!",
        isSent = false
    )
}