package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {

    OutlinedTextField(value = valueState.value,
        onValueChange = { valueState.value = it},
        label = { Text(text = labelId)},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction)


}

@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default,
) {

    val visualTransformation = if (passwordVisibility.value) VisualTransformation.None else
        PasswordVisualTransformation()
    OutlinedTextField(value = passwordState.value,
        onValueChange = {
            passwordState.value = it
        },
        label = { Text(text = labelId)},
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction),
        visualTransformation = visualTransformation,
        trailingIcon = {PasswordVisibility(passwordVisibility = passwordVisibility)},
        keyboardActions = onAction)

}