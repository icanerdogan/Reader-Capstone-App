package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1DarkGreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1Green
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1White
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.SerifTypography

@Composable
fun SignInputField(
    fieldState: MutableState<String>,
    inputImageVector: ImageVector,
    labelText: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = fieldState.value,
        onValueChange = {
            fieldState.value = it
        },
        singleLine = true,
        placeholder = {
            Text(labelText, style = SerifTypography.bodyLarge)
        },
        leadingIcon = {
            Icon(
                imageVector = inputImageVector,
                contentDescription = null,
                tint = Color1Green
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color1DarkGreen,
            unfocusedIndicatorColor = Color1Green,
            focusedLabelColor = Color1DarkGreen,
            unfocusedLabelColor = Color1Green
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp)
    )
}