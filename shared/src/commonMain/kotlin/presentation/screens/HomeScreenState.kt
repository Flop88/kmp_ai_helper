package presentation.screens

import domain.model.ChatModel

data class HomeScreenState(
    var isLoading: Boolean = false,
    var data: MutableList<ChatModel> = mutableListOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false,
)