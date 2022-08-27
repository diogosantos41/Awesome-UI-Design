package com.dscoding.awesomeuidesign.feature_mobile_banking

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.ui.theme.Shapes

@Composable
fun MobileBankingScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        CardSection()
        Spacer(modifier = Modifier.height(20.dp))
        ActionsSection()
        Spacer(modifier = Modifier.height(20.dp))
        RecentActivitySection()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(Shapes.medium)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = "Hey Jane", color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "Welcome Back", color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CardSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Blue

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 10.dp),
                )
                Text(
                    text = "$30,000.41",
                    color = Color.White,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(modifier = Modifier.size(40.dp), painter = painterResource(R.drawable.ic_mastercard), contentDescription = "")
            }
        }

    }
}

@Composable
fun ActionsSection() {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Actions", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(
                text = "Transfer",
                icon = painterResource(id = R.drawable.ic_login),
                backgroundColor = Color(0xffFEF4E7)
            )
            ActionButton(
                text = "Pay",
                icon = painterResource(id = R.drawable.ic_login),
                backgroundColor = Color(0xffFEF4E7)
            )
            ActionButton(
                text = "Withdraw",
                icon = painterResource(id = R.drawable.ic_login),
                backgroundColor = Color(0xffFEF4E7)
            )
            ActionButton(
                text = "Request",
                icon = painterResource(id = R.drawable.ic_login),
                backgroundColor = Color(0xffFEF4E7)
            )
        }
    }
}

@Composable
fun ActionButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RecentActivitySection() {
    Column {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Recent activity", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }
        // Activity List
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        MobileBankingScreen()
    }
}
