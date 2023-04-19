import androidx.compose.runtime.Composable
import presentation.screens.HomeViewModel

actual fun getPlatformName(): String = "Android"


@Composable
fun MainView() {
    App()
}