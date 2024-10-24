package io.github.joaogouveia89.tikodog.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val TikoPurple = Color(0xFF812578)
val TikoPink = Color(0xFFFDE0EA)
val TikoBlue = Color(0xFF9BB8E5)

val TikoGray = Color(0xFF8190A4)
val TikoGray2 = Color(0xFFE6EBEE)

val backgroundGradient = Brush.linearGradient(
    colors = listOf(
        TikoPink,
        TikoBlue
    ),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)