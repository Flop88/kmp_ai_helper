@file:OptIn(ExperimentalComposeUiApi::class)

package presentation.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SendMessageSection(
    onSendClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var message by remember { mutableStateOf("") }
    var isEnabled by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val (textField, icon) = createRefs()

        OutlinedTextField(
            value = message,
            onValueChange = {
                message = it
                isEnabled = message.isNotEmpty()
            },
            label = {
                Text(text = "Ваш текст")
            },
            modifier = Modifier.padding(10.dp),
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = MaterialTheme.colors.primary,
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface,
                disabledIndicatorColor = MaterialTheme.colors.onSurface,
                errorIndicatorColor = MaterialTheme.colors.error
            )
        )
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "send",
            tint = if (isEnabled) MaterialTheme.colors.onSurface else MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(25.dp)
                .clickable {
                    if (isEnabled) {
                        onSendClicked(message)
                        message = ""
                    }
                }
        )
//        Image(
//            imageVector = Icons.Default.Send,
//            contentDescription = "send",
//            modifier = Modifier
//                .padding(start = 16.dp)
//                .size(25.dp)
//                .clickable {
//                    if (isEnabled) {
//                        onSendClicked(message)
//                        message = ""
//                    }
//                }
//        )
//        Image(
//            painterResource("compose-multiplatform.xml"),
//            null
//        )
    }
}


//@Preview(showBackground = true, backgroundColor = 0x00ffffff)
@Composable
fun previewSendMessageSection() {
    MaterialTheme {
//        SendMessageSection()
    }
}