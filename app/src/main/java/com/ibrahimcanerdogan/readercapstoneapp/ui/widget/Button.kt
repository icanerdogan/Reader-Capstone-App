package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1Green
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Typography

@Composable
fun FABContent(onTap: () -> Unit) {
    FloatingActionButton(
        onClick = { onTap() },
        shape = RoundedCornerShape(50.dp),
        containerColor = Color(0xFF92CBDF)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a Book",
            tint = Color.White
        )

    }
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val visible = passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value = !visible }) {
        Icons.Default.Close
    }
}

@Composable
fun OnboardingNextButton(imageVector: ImageVector, onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = { onClick.invoke() },
        modifier = Modifier.border(BorderStroke(1.dp, Color.White), RoundedCornerShape(15.dp)),
        containerColor = Color1Green
    ) {
        Icon(
            imageVector = imageVector,
            modifier = Modifier.size(20.dp),
            tint = Color.White,
            contentDescription = "Onboarding Next Button"
        )
    }
}

@Composable
fun OnboardingGetStartedButton(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .width(180.dp)
            .border(BorderStroke(1.dp, Color.White), RoundedCornerShape(15.dp)),
        containerColor = Color1Green,
        contentColor = Color.White
    ) {
        Text(text = "Get Started", style = Typography.titleSmall)
    }
}