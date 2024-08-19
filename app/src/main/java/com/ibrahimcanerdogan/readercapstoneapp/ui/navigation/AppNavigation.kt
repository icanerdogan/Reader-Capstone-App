package com.ibrahimcanerdogan.readercapstoneapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.detail.DetailScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.home.HomeScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.home.HomeViewModel
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.login.LoginScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.search.SearchScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.search.SearchViewModel
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.splash.SplashScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.static.StaticScreen
import com.ibrahimcanerdogan.readercapstoneapp.ui.screen.update.UpdateScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreen.SplashScreen.name ){

        composable(AppScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
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
        composable("$detailName/{bookId}", arguments = listOf(navArgument("bookId"){
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
            })) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("bookItemId").let {
                UpdateScreen(navController = navController, bookItemId = it.toString())
            }

        }

    }

}