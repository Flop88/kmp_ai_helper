package presentation.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularButton(
    interactionSource: MutableInteractionSource,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    borderStroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable RowScope.() -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    Button(
        onClick = {},
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        border = borderStroke,
        elevation = elevation,
        contentPadding = contentPadding,
        content = content,
        modifier = modifier,
        interactionSource = interactionSource
    )
}

//@Preview(showBackground = true, backgroundColor = 0x00ffffff)
@Composable
fun previewDefaultState() {
    MaterialTheme {
        CircularButton(
            interactionSource = remember { MutableInteractionSource() },
            backgroundColor = Color.Green,
            contentColor = Color.White,
            borderStroke = BorderStroke(2.dp, Color.Black),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(text = "Click me!")
        }
    }
}
