package presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import domain.model.ChatModel
import presentation.screens.HomeScreen
import presentation.screens.HomeScreenState
import presentation.screens.HomeViewModel

@Composable
internal fun VoiceApp() {
    val viewModel = remember { HomeViewModel() }

    val uiState by viewModel.uiState.collectAsState()
    HomeScreen(
        uiState = uiState,
        sendMessage = { viewModel.sendMessage(it) }
    )
}