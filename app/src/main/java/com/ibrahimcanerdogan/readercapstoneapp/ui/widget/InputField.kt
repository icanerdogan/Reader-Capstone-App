package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId: String = "Email",
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    InputField(modifier = modifier,
        valueState = emailState,
        labelId = labelId,
        enabled = enabled,
        keyboardType = KeyboardType.Email,
        imeAction = imeAction,
        onAction = onAction)


}