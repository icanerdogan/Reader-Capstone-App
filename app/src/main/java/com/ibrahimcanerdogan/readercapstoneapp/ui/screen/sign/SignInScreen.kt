package com.ibrahimcanerdogan.readercapstoneapp.ui.screen.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ibrahimcanerdogan.readercapstoneapp.R
import com.ibrahimcanerdogan.readercapstoneapp.ui.navigation.AppScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.SerifTypography
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.OutlinedSignButton
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignButton
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignInputField
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignTextButton

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val inputEmailUsername = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { contentPadding ->
        Surface(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(contentPadding)) {
            Column(
                modifier = modifier.fillMaxSize().background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.icon_sign_in), contentDescription = "Sign in Icon")
                Text(
                    text = "Sign in",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    style = SerifTypography.titleLarge
                )
                SignInputField(
                    fieldState = inputEmailUsername,
                    labelText = "Email or Username",
                    inputImageVector = Icons.Default.Email,
                    keyboardType = KeyboardType.Email
                )
                SignInputField(
                    fieldState = inputPassword,
                    labelText = "Password",
                    inputImageVector = Icons.Default.Password,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
                SignButton(signLabelText = "Sign in") {
                    // TODO: navigate to home screen
                    viewModel.signInWithEmailAndPassword(inputEmailUsername.value, inputPassword.value){
                        navController.navigate(AppScreen.ReaderHomeScreen.name)
                    }
                }
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp))
                
                OutlinedSignButton(signLabelText = "Sign in with Google") {
                    // TODO: google sign in screen
                }
                SignTextButton(signLabelText = "Don’t have account? Sign up") {
                    navController.navigate(AppScreen.SignUpScreen.name)
                }
            }
        }
    }
}

