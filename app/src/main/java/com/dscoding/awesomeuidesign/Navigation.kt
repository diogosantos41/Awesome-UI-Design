package com.dscoding.awesomeuidesign

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dscoding.awesomeuidesign.feature_crypto_currency.CryptoCurrencyScreen
import com.dscoding.awesomeuidesign.feature_dashboard.DashboardScreen
import com.dscoding.awesomeuidesign.feature_grocery_shop.GroceryShopScreen
import com.dscoding.awesomeuidesign.feature_login_screen.LoginScreen
import com.dscoding.awesomeuidesign.feature_mobile_banking.MobileBankingScreen
import com.dscoding.awesomeuidesign.feature_social_media.SocialMediaScreen
import com.dscoding.awesomeuidesign.feature_speed_test.SpeedTestScreen
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
            MobileBankingScreen()
        }
        composable(route = Screen.GroceryShopScreen.route) {
            GroceryShopScreen()
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = Screen.SocialMediaScreen.route) {
            SocialMediaScreen()
        }
        composable(route = Screen.CryptoCurrencyScreen.route) {
            CryptoCurrencyScreen()
        }
        composable(route = Screen.SpeedTestScreen.route) {
            SpeedTestScreen()
        }
    }
}