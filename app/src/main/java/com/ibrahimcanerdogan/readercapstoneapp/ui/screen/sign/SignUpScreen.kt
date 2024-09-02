package com.ibrahimcanerdogan.readercapstoneapp.ui.screen.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.TagFaces
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
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignBackButton
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignButton
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.SignInputField

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SignViewModel = hiltViewModel()
) {
    val inputFullName = remember { mutableStateOf("") }
    val inputUsername = remember { mutableStateOf("") }
    val inputEmail = remember { mutableStateOf("") }
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
                Column(modifier = Modifier.wrapContentSize().padding(horizontal = 15.dp)) {
                    SignBackButton {
                        navController.navigate(AppScreen.SignInScreen.name) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                    Image(painter = painterResource(id = R.drawable.icon_sign_up), contentDescription = "Sign up Icon")
                }
                Text(
                    text = "Sign up",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    style = SerifTypography.titleLarge
                )
                SignInputField(
                    fieldState = inputFullName,
                    labelText = "Full Name",
                    inputImageVector = Icons.Default.TagFaces,
                    keyboardType = KeyboardType.Email
                )
                SignInputField(
                    fieldState = inputUsername,
                    labelText = "Username",
                    inputImageVector = Icons.Default.PersonOutline,
                    keyboardType = KeyboardType.Email
                )
                SignInputField(
                    fieldState = inputEmail,
                    labelText = "Email",
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
                SignButton(signLabelText = "Continue") {
                    viewModel.createUserWithEmailAndPassword(inputEmail.value, inputPassword.value) {
                        navController.navigate(AppScreen.ReaderHomeScreen.name)
                    }
                }

                /*
                SignTextButton(signLabelText = "By signing up, you're agree to our Terms & Conditions and Privacy Policy.") {
                    // TODO: open to our terms.
                }
                */
            }
        }
    }
}

