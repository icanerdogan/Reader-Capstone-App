package com.ibrahimcanerdogan.readercapstoneapp

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.ibrahimcanerdogan.readercapstoneapp.ui.navigation.AppScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context
): ViewModel() {

    var splashScreenCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(AppScreen.OnboardingScreen.name)
        private set

    init {
        viewModelScope.launch(Dispatchers.Main) {
            val dataStore = context.dataStore
            val seenOnboarding: Boolean

            val seen = dataStore.data.first()[PREFERENCES_KEY_ONBOARDING] ?: false
            seenOnboarding = seen

            val currentUser = FirebaseAuth.getInstance().currentUser == null

            if (currentUser && !seenOnboarding) {
                startDestination = AppScreen.OnboardingScreen.name
                dataStore.edit { preferences ->
                    preferences[PREFERENCES_KEY_ONBOARDING] = true
                }
            }else if (currentUser) {
                startDestination = AppScreen.SignInScreen.name
            } else {
                startDestination = AppScreen.ReaderHomeScreen.name
            }
            Handler(Looper.getMainLooper()).postDelayed({
                splashScreenCondition = false
            }, 1000)
        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

private val PREFERENCES_KEY_ONBOARDING = booleanPreferencesKey("onboarding_key")