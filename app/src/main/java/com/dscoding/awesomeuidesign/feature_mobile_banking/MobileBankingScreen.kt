package com.dscoding.awesomeuidesign.feature_mobile_banking

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
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
import com.dscoding.awesomeuidesign.ui.theme.*
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MobileBankingScreen() {
    val state = rememberPagerState(pageCount = 3)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Column(modifier = Modifier.background(PurpleDark)) {
            Spacer(modifier = Modifier.height(20.dp))
            Header()
            Spacer(modifier = Modifier.height(70.dp))
        }
        Column(
            modifier = Modifier
                .offset(y = (-70).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            CardPager(pagerState = state)
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalPagerIndicator(
                pagerState = state,
                activeColor = PurpleDark
            )
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                ActionsSection()
                Spacer(modifier = Modifier.height(15.dp))
                RecentActivitySection()
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(Shapes.medium),
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = "Jane", color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Welcome back!", color = Color.White,
                fontSize = 18.sp,
            )
        }
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Transparent)
        )
        IconButton(onClick = { }, modifier = Modifier.width(28.dp)) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White,
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CardPager(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        BankingCard()
    }
}

@Composable
fun BankingCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 20.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Purple
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 10.dp),
                )
                Text(
                    text = "30,000.41€",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "**** **** **** 0321",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Transparent)
                    )
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(R.drawable.ic_mastercard),
                        contentDescription = ""
                    )
                }
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
                Text(text = "More", color = PurpleDark)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(
                text = "Transfer",
                icon = painterResource(id = R.drawable.ic_transfer),
                backgroundColor = WhiteDirty
            )
            ActionButton(
                text = "Pay",
                icon = painterResource(id = R.drawable.ic_pay),
                backgroundColor = WhiteDirty
            )
            ActionButton(
                text = "Withdraw",
                icon = painterResource(id = R.drawable.ic_withdraw),
                backgroundColor = WhiteDirty
            )
            ActionButton(
                text = "Request",
                icon = painterResource(id = R.drawable.ic_request),
                backgroundColor = WhiteDirty
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
        Spacer(modifier = Modifier.height(5.dp))
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
                Text(text = "More", color = PurpleDark)
            }
        }
        val items = getBankingActivity()
        items.forEach {
            ActivityItem(it)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ActivityItem(bankingActivity: BankingActivity) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(
                color = WhiteDirty,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 12.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 10.dp), verticalAlignment = CenterVertically) {
            Image(
                painter = painterResource(id = bankingActivity.icon),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = bankingActivity.title, color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = bankingActivity.date, color = Color.Black,
                    fontSize = 14.sp,
                )
            }
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Transparent)
            )
            Text(
                text = bankingActivity.amount, color = bankingActivity.amountColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        MobileBankingScreen()
    }
}
