package domain.repository

import domain.model.ChatModel

interface ChatRepository {

    suspend fun getChatCompletions(text: String): ChatModel?

}