package com.dscoding.awesomeuidesign

sealed class Screen(val route: String) {
    object DashboardScreen: Screen("dashboard_screen")
    object MobileBankingScreen: Screen("mobile_banking_screen")
    object GroceryShopScreen: Screen("grocery_shop_screen")
    object LoginScreen: Screen("login_screen")
    object SocialMediaScreen: Screen("social_media_screen")
    object CryptoCurrencyScreen: Screen("crypto_currency_screen")
}