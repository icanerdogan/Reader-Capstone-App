package com.ibrahimcanerdogan.readercapstoneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.navigation.AppNavigation
import com.ibrahimcanerdogan.readercapstoneapp.ui.theme.ReaderCapstoneAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashScreenCondition
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            ReaderCapstoneAppTheme {
                ReaderApp(viewModel)
            }
        }
    }
}

@Composable
fun ReaderApp(viewModel: MainViewModel) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val startDestination = viewModel.startDestination
                AppNavigation(startDestination)
            }
        }
    )
}