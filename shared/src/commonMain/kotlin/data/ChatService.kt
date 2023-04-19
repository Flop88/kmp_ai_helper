package data

import data.model.ChatCompletionsRequest
import data.model.ChatCompletionsResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class ChatService : KtorApi() {

    suspend fun getCompletions(requestBody: ChatCompletionsRequest): ChatCompletionsResponse =
        client.post {
            pathUrl("v1/completions")
            setBody(requestBody)
        }.body()
//        client.post {
//            url("v1/completions")
//            method = HttpMethod.Post
//            body = requestBody
//            contentType(ContentType.Application.Json)
//
//        }

}