package presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.ChatModel
import presentation.items.ChatMessageItem
import presentation.items.CircularButton
import presentation.items.SendMessageSection

val TAG: String = "HomeScreen"

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    sendMessage: (ChatModel) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        when {
            uiState.isLoading -> {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(color = Color.Red)
                }
            }
            uiState.errorMessage != null -> {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = uiState.errorMessage!!, color = Color.Red)
                }
            }
            uiState.loadFinished -> {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        LazyColumn {
                            items(uiState.data) {
                                ChatMessageItem(it.message, it.isSent)
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        SendMessageSection(
                            onSendClicked = {
                                sendMessage(ChatModel(0, message = it, isSent = true))
                            },
                            modifier = Modifier
                                .padding(top = 38.dp)
                        )
                    }
                }
            }
            else -> {
                DefaultState(sendMessage)
            }
        }
    }

}

@Composable
private fun DefaultState(sendMessage: (ChatModel) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
//    val context = LocalContext.current
//    val getVoice = SpeachUtils.getVoiceText(context) { text ->
//        sendMessage(ChatModel(0, message = text, isSent = true))
//    }
//    val launcher = getVoice.first
//    val pendIntent = getVoice.second
//
//    if (isPressed){
//        println("Pressed")
//        launcher.launch(
//            IntentSenderRequest.Builder(pendIntent)
//                .build()
//        )
//        DisposableEffect(Unit) {
//            onDispose {
//                println("Unpressed")
//            }
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Column {
            Text(
                text = "Just say...",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "I have milk, tomatoes, bread...",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 19.dp)
                    .fillMaxWidth()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularButton(
                interactionSource = interactionSource,
                backgroundColor = Color.White,
                contentColor = Color.White,
                borderStroke = BorderStroke(1.dp, Color.Black),
                contentPadding = PaddingValues(16.dp)
            ) {
                Image(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(46.dp)
                )
            }
        }
        Column {
            Text(
                text = "Or write...",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            SendMessageSection(
                onSendClicked = {
                    sendMessage(ChatModel(0, message = it, isSent = true))
                },
                modifier = Modifier
                    .padding(top = 38.dp)
            )
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0x00ffffff)
@Composable
fun previewDefaultState() {
    MaterialTheme {
        DefaultState {}
    }
}

