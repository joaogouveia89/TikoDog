package io.github.joaogouveia89.tikodog.core.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Transparent,
            textColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = borderColor
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
            borderColor = MaterialTheme.colors.primary
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
        borderColor = MaterialTheme.colors.primary,
        onChangeValue = {}
    )
}