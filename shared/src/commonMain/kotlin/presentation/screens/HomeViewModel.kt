package presentation.screens

import domain.model.ChatModel
import domain.usecase.GetChatCompletionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CoroutineViewModel

class HomeViewModel(
//    private val repository: GetChatCompletionUseCase
) : CoroutineViewModel(), KoinComponent {

    private val repository: GetChatCompletionUseCase by inject()

    init {
        println("HomeViewModel:: HomeViewModel init data")
    }

    val uiState = MutableStateFlow(HomeScreenState())

//    private val _chatData = MutableStateFlow<MutableList<ChatModel>>(mutableListOf())


    fun sendMessage(chat: ChatModel) {
        if (uiState.value.isLoading) return
        uiState.value.data.add(chat)
//        _chatData.value = _uiState.value.data
        println("HomeScreenViewModel: list size: ${uiState.value.data.size}")

        coroutineScope.launch {
            uiState.value = uiState.value.copy(isLoading = true)

            try {
                val result = repository.invoke(text = chat.message)

                result?.let {
                    uiState.value.data.add(result)

                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        loadFinished = true,
                        data = uiState.value.data
                    )
                }

                if (result == null) {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        loadFinished = true,
                        data = mutableListOf()
                    )
                }

            } catch (error: Exception) {
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    loadFinished = true,
                    errorMessage = "Oh, something went wrong!" + error.message
                )
            }
        }
    }

    fun observeData(onChange: (HomeScreenState) -> Unit) {
        uiState.onEach {
            onChange(it)
        }.launchIn(coroutineScope)
    }

}