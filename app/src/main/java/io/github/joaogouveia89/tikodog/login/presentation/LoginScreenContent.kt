package io.github.joaogouveia89.tikodog.login.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.joaogouveia89.tikodog.R
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTextInput
import io.github.joaogouveia89.tikodog.login.presentation.components.TikoDogPasswordInput
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    Column(
        modifier = modifier
            .padding(paddingValues)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 64.dp)
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                imageVector = ImageVector.vectorResource(R.drawable.ic_sign_up),
                tint = Color.White,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(R.string.sign_in),
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        TikoDogTextInput(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            label = "Email",
            hint = "Please add your email",
            endIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    tint = Color.Black,
                    contentDescription = null
                )
            },
            onChangeValue = {}
        )
        TikoDogPasswordInput(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            onChangeValue = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    TikoDogTheme {
        LoginScreen()
    }
}