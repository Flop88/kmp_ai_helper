package domain.usecase

import domain.model.ChatModel
import domain.repository.ChatRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetChatCompletionUseCase: KoinComponent {
    private val repository: ChatRepository by inject()

    suspend operator fun invoke(text: String): ChatModel? {
        println("GetChatCompletionUseCase invoke: $text")
        return try {
            //Дай мне короткий ответ на вопрос:
//            val requestText = "3 рецепта блюд используя эти: $text."
            val requestText = "опиши кратко с примером: $text."
            repository.getChatCompletions(text = requestText)
        } catch (e: Exception) {
            throw Throwable(message = "request message is empty")
        }
    }
}