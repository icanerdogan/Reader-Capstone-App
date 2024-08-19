package com.ibrahimcanerdogan.readercapstoneapp.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.auth.FirebaseAuth
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.detail.DetailScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.home.HomeScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.home.HomeViewModel
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.login.LoginScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.onboarding.OnboardingScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.search.SearchScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.search.SearchViewModel
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.static.StaticScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.update.UpdateScreen
import kotlinx.coroutines.flow.first

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var startDestination: String? = null
    val context = LocalContext.current
    val dataStore = context.dataStore
    val seenOnboarding = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val seen = dataStore.data.first()[PREFERENCES_KEY_ONBOARDING] ?: false
        seenOnboarding.value = seen
    }

    val currentUser = FirebaseAuth.getInstance().currentUser == null

    if (currentUser && !seenOnboarding.value) {
        startDestination = AppScreen.OnboardingScreen.name
        LaunchedEffect(Unit) {
            dataStore.edit { preferences ->
                preferences[PREFERENCES_KEY_ONBOARDING] = true
            }
        }
    }else if (currentUser) {
        startDestination = AppScreen.LoginScreen.name
    } else {
        startDestination = AppScreen.ReaderHomeScreen.name
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppScreen.OnboardingScreen.name) {
            OnboardingScreen(navController = navController)
        }

        composable(AppScreen.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(AppScreen.ReaderStatsScreen.name) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            StaticScreen(navController = navController, viewModel = homeViewModel)
        }

        composable(AppScreen.ReaderHomeScreen.name) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }

        composable(AppScreen.SearchScreen.name) {
            val searchViewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(navController = navController, viewModel = searchViewModel)
        }

        val detailName = AppScreen.DetailScreen.name
        composable("$detailName/{bookId}", arguments = listOf(navArgument("bookId") {
            type = NavType.StringType
        })) { backStackEntry ->
            backStackEntry.arguments?.getString("bookId").let {

                DetailScreen(navController = navController, bookId = it.toString())
            }
        }

        val updateName = AppScreen.UpdateScreen.name
        composable("$updateName/{bookItemId}",
            arguments = listOf(navArgument("bookItemId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("bookItemId").let {
                UpdateScreen(navController = navController, bookItemId = it.toString())
            }
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

private val PREFERENCES_KEY_ONBOARDING = booleanPreferencesKey("onboarding_key")