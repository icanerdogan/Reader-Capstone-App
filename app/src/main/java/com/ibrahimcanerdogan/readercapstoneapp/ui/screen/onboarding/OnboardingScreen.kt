package com.ibrahimcanerdogan.readercapstoneapp.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ibrahimcanerdogan.readercapstoneapp.R
import com.ibrahimcanerdogan.readercapstoneapp.ui.navigation.AppScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1DarkGreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1Green
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.Color1White
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.BaseTypography
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.OnboardingGetStartedButton
import com.ibrahimcanerdogan.readercapstoneapp.ui.widget.OnboardingNextButton

data class OnboardingModel(
    val id : Int,
    val imageVector: Int,
    val title: Int,
    val subtitle: Int,
)

@Composable
fun OnboardingScreen(navController: NavHostController) {
    val radioOptions = listOf(
        OnboardingModel(0, R.drawable.icon_onboarding1, R.string.onboarding1_title, R.string.onboarding1_subtitle),
        OnboardingModel(1, R.drawable.icon_onboarding2, R.string.onboarding2_title, R.string.onboarding2_subtitle),
        OnboardingModel(2, R.drawable.icon_onboarding3, R.string.onboarding3_title, R.string.onboarding3_subtitle),
    )
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0] ) }
    val currentIndex = radioOptions.indexOf(selectedOption)
    val nextIndex = (currentIndex + 1) % radioOptions.size

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color1White),
        floatingActionButton = {
            if (nextIndex != 0){
                OnboardingNextButton(Icons.AutoMirrored.Filled.ArrowForwardIos) {
                    onOptionSelected(radioOptions[nextIndex])
                }
            } else {
                OnboardingGetStartedButton {
                    navController.navigate(AppScreen.SignInScreen.name)
                }
            }
        }
    ) { contentAlignment ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color1White)
                .padding(contentAlignment),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.app_banner_name),
                modifier = Modifier.fillMaxWidth().weight(1f),
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = BaseTypography.titleLarge
            )
            Image(
                painter = painterResource(selectedOption.imageVector),
                modifier = Modifier.fillMaxWidth().weight(3f).padding(10.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Onboarding Icon"
            )
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                radioOptions.forEach { model ->
                    Row(
                        Modifier
                            .selectable(
                                selected = (model == selectedOption),
                                onClick = {
                                    onOptionSelected(model)
                                }
                            )
                    ) {
                        RadioButton(
                            selected = (model == selectedOption),
                            onClick = { onOptionSelected(model) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color1DarkGreen,
                                unselectedColor = Color1Green
                            )
                        )
                    }
                }
            }
            Text(
                text = stringResource(id = selectedOption.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .weight(.5f),
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = BaseTypography.titleSmall
            )
            Text(
                text = stringResource(id = selectedOption.subtitle),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .weight(.5f),
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = BaseTypography.bodyLarge
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}