package com.dscoding.awesomeuidesign

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.utils.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    val horizontalPadding = 16.dp

    Column(
        Modifier
            .background(White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = horizontalPadding)
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "Awesome UI Design", fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
        Text(
            text = "App Design Ideas",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color(R.color.black)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Item(
                icon = ImageVector.vectorResource(id = R.drawable.ic_mobile_banking),
                title = "Mobile Banking",
                subtitle = "Awesome UI Design",
                onClick = { navController.navigate(Screen.MobileBankingScreen.route) })
            Item(
                icon = ImageVector.vectorResource(id = R.drawable.ic_social_media),
                title = "Social Media",
                subtitle = "Awesome UI Design",
                onClick = { navController.navigate(Screen.SocialMediaScreen.route) })
            Item(
                icon = ImageVector.vectorResource(id = R.drawable.ic_crypto_currency),
                title = "Crypto Currency",
                subtitle = "Awesome UI Design",
                onClick = { navController.navigate(Screen.CryptoCurrencyScreen.route) })

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "To be implemented..",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(R.color.black)
            )
            Item(
                icon = ImageVector.vectorResource(id = R.drawable.ic_login),
                title = "Login Screen",
                subtitle = "Awesome UI Design",
                onClick = { navController.navigate(Screen.LoginScreen.route) })
            Item(
                icon = ImageVector.vectorResource(id = R.drawable.ic_grocery_shop),
                title = "Grocery Shop",
                subtitle = "Awesome UI Design",
                onClick = { navController.navigate(Screen.GroceryShopScreen.route) })
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun Item(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        backgroundColor = White,
        elevation = 4.dp,
        contentColor = Color.Black
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(text = title)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(onClick = onClick, modifier = Modifier.align(Alignment.Top)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        DashboardScreen(navController = rememberNavController())
    }
}
