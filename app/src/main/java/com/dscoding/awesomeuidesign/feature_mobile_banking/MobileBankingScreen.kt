package com.dscoding.awesomeuidesign.feature_mobile_banking

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme

@Composable
fun MobileBankingScreen(navController: NavController) {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        MobileBankingScreen(navController = rememberNavController())
    }
}
