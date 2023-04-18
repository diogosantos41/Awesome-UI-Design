package com.dscoding.awesomeuidesign.utils

sealed class Screen(val route: String) {
    object DashboardScreen: Screen("dashboard_screen")
    object MobileBankingScreen: Screen("mobile_banking_screen")
    object GroceryShopScreen: Screen("grocery_shop_screen")
    object LoginScreen: Screen("login_screen")
    object SocialMediaScreen: Screen("social_media_screen")
    object CryptoCurrencyScreen: Screen("crypto_currency_screen")
    object SpeedTestScreen: Screen("speed_test_screen")
}