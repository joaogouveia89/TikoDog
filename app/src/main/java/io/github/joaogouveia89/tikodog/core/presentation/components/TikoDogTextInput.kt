package io.github.joaogouveia89.tikodog.core.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray

@Composable
fun TikoDogTextInput(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    onChangeValue: (String) -> Unit,
    initialValue: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    borderColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    endIcon: @Composable (() -> Unit)? = null
) {

    var value by rememberSaveable { mutableStateOf(initialValue) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            value = it
            onChangeValue(it)
        },
        colors = OutlinedTextFieldDefaults.colors().copy(
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = borderColor // border color
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        label = {
            Text(
                text = label,
                color = TikoGray
            )
        },
        placeholder = {
            Text(
                text = hint,
                color = TikoGray
            )
        },
        trailingIcon = endIcon,
        visualTransformation = visualTransformation
    )
}

@Preview(showBackground = true)
@Composable
private fun TikoDogTextInputPreview() {
    TikoDogTheme {
        TikoDogTextInput(
            modifier = Modifier.padding(20.dp),
            label = "Name",
            hint = "Enter your name",
            onChangeValue = {},
            borderColor = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TikoDogTextInputWithIconPreview() {
    TikoDogTextInput(
        modifier = Modifier.padding(20.dp),
        label = "Email",
        hint = "Enter your email",
        endIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        },
        borderColor = MaterialTheme.colorScheme.primary,
        onChangeValue = {}
    )
}