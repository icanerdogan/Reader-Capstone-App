package com.ibrahimcanerdogan.readercapstoneapp.ui.widget

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahimcanerdogan.readercapstoneapp.R
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.BaseTypography
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1DarkGreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1Green
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.SerifTypography

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

@Preview
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
        Text(text = "Get Started", style = BaseTypography.titleSmall)
    }
}

@Composable
fun SignButton(
    signLabelText: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 10.dp, horizontal = 30.dp)
            .clip(RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color1Green
        )
    ) {
        Text(text = signLabelText, style = SerifTypography.titleSmall)
    }
}

@Preview
@Composable
private fun SignButtonPreview() {
    SignButton("Sign in") {
        Log.d("TAG", "Sign Button Clicked!")
    }
}

@Composable
fun OutlinedSignButton(
    signLabelText: String,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 10.dp, horizontal = 30.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(BorderStroke(1.dp, Color1Green)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        )
    ) {
        Text(text = signLabelText, color = Color1DarkGreen, style = SerifTypography.titleSmall)
    }
}

@Preview
@Composable
private fun OutlinedSignButtonPreview() {
    OutlinedSignButton("Sign in with Google") {
        Log.d("TAG", "Sign in with Google Clicked!")
    }
}

@Composable
fun SignTextButton(
    signLabelText: String,
    onClick: () -> Unit = {}
) {
    TextButton(onClick = { onClick.invoke() }) {
        Text(text = signLabelText, color = Color1DarkGreen, style = SerifTypography.titleSmall)
    }
}

@Preview
@Composable
private fun SignTextButtonPreview() {
    SignTextButton("Don’t have account? Sign up") {
        Log.d("TAG", "Sign in with Google Clicked!")
    }
}

@Composable
fun SignBackButton(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .size(40.dp)
            .clickable(onClick = onClick),
        shape = CircleShape,
        color = Color1Green
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Sign Up Back",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewSignBackButton() {
    SignBackButton(onClick = {})
}