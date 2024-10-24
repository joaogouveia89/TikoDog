package io.github.joaogouveia89.tikodog.login.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.joaogouveia89.tikodog.R
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogTextInput
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray

@Composable
fun TikoDogPasswordInput(
    modifier: Modifier = Modifier,
    onChangeValue: (String) -> Unit
) {
    var isVisible by rememberSaveable { mutableStateOf(false) }

    TikoDogTextInput(
        modifier = modifier,
        label = "Password",
        hint = "Enter your password",
        keyboardType = KeyboardType.Password,
        onChangeValue = onChangeValue,
        endIcon = {
            val description = if (isVisible)
                stringResource(R.string.show_password)
            else
                stringResource(R.string.hide_password)
            val iconImage =
                if (isVisible)
                    Icons.Default.VisibilityOff
                else
                    Icons.Default.Visibility
            IconButton(onClick = {
                isVisible = !isVisible
            }) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description,
                    tint = TikoGray,
                )
            }
        },
        visualTransformation = if (isVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        borderColor = Color.White
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF9BB8E5)
@Composable
private fun TikoDogPasswordInputPreview() {
    TikoDogPasswordInput(
        modifier = Modifier.padding(20.dp),
        onChangeValue = {}
    )
}