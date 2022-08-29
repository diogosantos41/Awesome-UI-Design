package com.dscoding.awesomeuidesign.feature_mobile_banking

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.Green
import com.dscoding.awesomeuidesign.ui.theme.GreenDark
import com.dscoding.awesomeuidesign.ui.theme.GreyDark
import com.dscoding.awesomeuidesign.ui.theme.Purple


data class BankingCard(
    var balance: String,
    var lastDigits: String,
    var color: Color
)


fun getBankingCards(): List<BankingCard> {
    val cards = mutableListOf<BankingCard>()
    cards.add(BankingCard("30,000.41€", "0321", Purple))
    cards.add(BankingCard("10.232,12€", "9102", GreyDark))
    cards.add(BankingCard("230.00€", "4132", GreenDark))
    return cards
}

data class BankingTransaction(
    var icon: Int,
    var title: String,
    var date: String,
    var amount: String,
    var amountColor: Color
)

fun getBankingTransactions(): List<BankingTransaction> {
    val transactions = mutableListOf<BankingTransaction>()
    transactions.add(
        BankingTransaction(
            R.drawable.ic_transfer,
            "Transfer from Mark",
            "23/07/2022",
            "+320.10€",
            Green
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_pay,
            "Netflix Subscription",
            "12/07/2022",
            "-19.99€",
            Color.Black
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_pay,
            "ATM Withdraw",
            "06/07/2022",
            "-50.00€",
            Color.Black
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_withdraw,
            "Transfer from Steve",
            "04/07/2022",
            "+10.30€",
            Green
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_pay,
            "Spotify Subscription",
            "04/07/2022",
            "-20.00€",
            Color.Black
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_pay,
            "Service Payment",
            "04/07/2022",
            "-34.32€",
            Color.Black
        )
    )
    transactions.add(
        BankingTransaction(
            R.drawable.ic_transfer,
            "Salary",
            "02/07/2022",
            "+1310.22€",
            Green
        )
    )
    return transactions
}

data class BankingMenuNavigation(
    var icon: ImageVector,
    var title: String
)

fun getBankingMenuNavigation(): List<BankingMenuNavigation> {
    val menu = mutableListOf<BankingMenuNavigation>()
    menu.add(BankingMenuNavigation(Icons.Default.Home, "Home"))
    menu.add(BankingMenuNavigation(Icons.Default.MailOutline, "Messages"))
    menu.add(BankingMenuNavigation(Icons.Default.AccountCircle, "Account"))
    menu.add(BankingMenuNavigation(Icons.Default.Settings, "Settings"))
    return menu
}
