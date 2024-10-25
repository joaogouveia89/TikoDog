package io.github.joaogouveia89.tikodog.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoPurple

@Composable
fun TikoDogButton(
    modifier: Modifier = Modifier,
    text: String,
    trailIcon: ImageVector,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(77.dp),
        content = {
            Row(
                modifier = Modifier.padding(horizontal = 48.dp, vertical = 8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    text = text,
                    style = MaterialTheme.typography.caption
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = trailIcon,
                    contentDescription = null
                )
            }

        },
        onClick = onClick,

        colors = ButtonDefaults.buttonColors(
            backgroundColor = containerColor,
            contentColor = contentColor
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun TikoDogButtonPreview() {
    TikoDogTheme {
        TikoDogButton(
            modifier = Modifier
                .padding(20.dp),
            text = "Sign In",
            trailIcon = Icons.AutoMirrored.Filled.Login,
            onClick = {},
            contentColor = Color.White,
            containerColor = TikoPurple
        )
    }
}