package com.dscoding.awesomeuidesign

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dscoding.awesomeuidesign.feature_mobile_banking.MobileBankingScreen
import com.dscoding.awesomeuidesign.utils.Screen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DashboardScreen.route)
    {
        composable(route = Screen.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
        composable(route = Screen.MobileBankingScreen.route) {
            MobileBankingScreen(navController = navController)
        }
        composable(route = Screen.GroceryShopScreen.route) {
            // GroceryShopScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            // LoginScreen(navController = navController)
        }
        composable(route = Screen.SocialMediaScreen.route) {
            // SocialMediaScreen(navController = navController)
        }
        composable(route = Screen.CryptoCurrencyScreen.route) {
            // CryptoCurrencyScreen(navController = navController)
        }
    }
}