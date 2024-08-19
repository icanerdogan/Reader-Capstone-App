package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(text = "A. Reader",
        modifier = modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.titleMedium,
        color = Color.Red.copy(alpha = 0.5f)
    )
}