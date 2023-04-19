package presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ChatMessageItem(text: String, isSent: Boolean) {
    val backgroundColor = if (isSent) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.secondary
    val contentColor = Color.Black
    val arrangement = if (isSent) Arrangement.End else Arrangement.Start
    val shape = if (isSent) {
        RoundedCornerShape(
            topEnd = 30.dp,
            topStart = 30.dp,
            bottomStart = 30.dp,
            bottomEnd = 0.dp
        )
    } else {
        RoundedCornerShape(
            topEnd = 30.dp,
            topStart = 30.dp,
            bottomStart = 0.dp,
            bottomEnd = 30.dp
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = arrangement
    ) {
        Card(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            modifier = Modifier
                .padding(8.dp),
            shape = shape
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 15.dp
                    ),
                textAlign = TextAlign.Start
            )
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0x00ffffff)
@Composable
fun previewChatMessage() {
    MaterialTheme {
        ChatMessageItem("test request", isSent = true)
        ChatMessageItem("test response", isSent = false)
    }
}