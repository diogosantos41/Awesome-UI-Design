package com.dscoding.awesomeuidesign.feature_mobile_banking

import androidx.compose.ui.graphics.Color
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.Green


data class BankingActivity(
    var icon: Int,
    var title: String,
    var date: String,
    var amount: String,
    var amountColor: Color
) {}

fun getBankingActivity(): List<BankingActivity> {
    var activities = mutableListOf<BankingActivity>()
    activities.add(
        BankingActivity(
            R.drawable.ic_transfer,
            "Transfer from Mark",
            "23/07/2022",
            "+320.10€",
            Green
        )
    )
    activities.add(
        BankingActivity(
            R.drawable.ic_pay,
            "Netflix Subscription",
            "12/07/2022",
            "-19.99€",
            Color.Black
        )
    )
    activities.add(BankingActivity(R.drawable.ic_pay, "ATM Withdraw", "06/07/2022", "-50.00€", Color.Black))
    activities.add(
        BankingActivity(
            R.drawable.ic_withdraw,
            "Transfer from Steve",
            "04/07/2022",
            "+10.30€",
            Green
        )
    )
    activities.add(
        BankingActivity(
            R.drawable.ic_pay,
            "Spotify Subscription",
            "04/07/2022",
            "-20.00€",
            Color.Black
        )
    )
    activities.add(
        BankingActivity(
            R.drawable.ic_pay,
            "Service Payment",
            "04/07/2022",
            "-34.32€",
            Color.Black
        )
    )
    activities.add(BankingActivity(R.drawable.ic_transfer, "Salary", "02/07/2022", "+1310.22€", Green))
    return activities
}
