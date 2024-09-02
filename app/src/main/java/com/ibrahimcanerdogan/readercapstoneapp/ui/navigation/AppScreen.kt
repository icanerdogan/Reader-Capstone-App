package com.ibrahimcanerdogan.readercapstoneapp.ui.navigation

enum class AppScreen {
    OnboardingScreen,
    SignInScreen,
    SignUpScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;

    companion object {
        fun fromRoute(route: String?): AppScreen = when(route?.substringBefore("/")) {
            OnboardingScreen.name -> OnboardingScreen
            SignInScreen.name -> SignInScreen
            SignUpScreen.name -> SignUpScreen
            ReaderHomeScreen.name -> ReaderHomeScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            UpdateScreen.name -> UpdateScreen
            ReaderStatsScreen.name -> ReaderStatsScreen
            null -> ReaderHomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}