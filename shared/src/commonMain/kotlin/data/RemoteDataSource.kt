package data

import data.model.ChatCompletionsRequest
import kotlinx.coroutines.withContext
import utils.Dispatcher

internal class RemoteDataSource(
    private val apiService: ChatService,
    private val dispatcher: Dispatcher
) {

    suspend fun getCompletions(text: String) =
        withContext(dispatcher.io) {
            val requestBody = ChatCompletionsRequest(
                model = "text-davinci-003",
                prompt = text + "\n",
                maxTokens = 4000,
                temperature = 0,
//                topP = 1,
//                n = 1,
//                stream = false,
//                logprobs = null,
//                stop = "\n",
            )
            apiService.getCompletions(requestBody = requestBody)
        }

}