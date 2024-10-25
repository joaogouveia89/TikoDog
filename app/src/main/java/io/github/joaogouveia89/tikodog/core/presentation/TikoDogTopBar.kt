package io.github.joaogouveia89.tikodog.core.presentation

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TikoDogTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        backgroundColor = Color.Transparent,
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                content = {
                    Icon(
                        imageVector = Icons.Default.ChevronLeft,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        },
        actions = {
            IconButton(
                onClick = onLogoutClick,
                content = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF9BB8E5)
@Composable
private fun TikoDogTopBarPreview() {
    TikoDogTopBar()
}