package data.repository

import data.RemoteDataSource
import domain.model.ChatModel
import domain.repository.ChatRepository
import utils.toChatModel

internal class ChatRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): ChatRepository {

    override suspend fun getChatCompletions(text: String): ChatModel? {
        return remoteDataSource.getCompletions(text = text).toChatModel()
    }

}