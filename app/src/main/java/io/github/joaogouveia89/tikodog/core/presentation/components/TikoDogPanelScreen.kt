package io.github.joaogouveia89.tikodog.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class PanelScreenHeader(
    val icon: ImageVector,
    val title: String
)

@Composable
fun TikoDogPanelScreen(
    header: PanelScreenHeader,
    content: @Composable () -> Unit
) {
    Header(headerInfo = header)
    ContentPanel(content)
}

@Composable
private fun ContentPanel(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                )
            )
            .background(Color.White)
            .padding(top = 40.dp),
    ) {
        content()
    }
}

@Composable
private fun Header(
    headerInfo: PanelScreenHeader
) {
    Row(
        modifier = Modifier.padding(start = 20.dp)
    ) {
        val elementsColor = Color.White

        Icon(
            modifier = Modifier
                .align(CenterVertically),
            imageVector = headerInfo.icon,
            tint = elementsColor,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = headerInfo.title,
            color = elementsColor,
            style = MaterialTheme.typography.h6
        )
    }
}