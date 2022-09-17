package com.dscoding.awesomeuidesign.feature_crypto_currency

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.Coral
import com.dscoding.awesomeuidesign.ui.theme.Green
import java.time.LocalDateTime
import java.time.Month


data class CryptoCurrency(
    var icon: Int,
    var name: String,
    var value: String,
    var code: String,
    var changes: String,
    var changesColor: Color
)

fun getCryptoCurrencies(): List<CryptoCurrency> {
    val cryptoCurrencies = mutableListOf<CryptoCurrency>()
    cryptoCurrencies.add(
        CryptoCurrency(
            icon = R.drawable.ic_coin_btc,
            name = "Bitcoin",
            value = "$36.641.20",
            code = "BTC",
            changes = "+3.23%",
            changesColor = Green
        )
    )
    cryptoCurrencies.add(
        CryptoCurrency(
            icon = R.drawable.ic_coin_blz,
            name = "Ethereum",
            value = "$2.321.32",
            code = "ETH",
            changes = "-10.02%",
            changesColor = Coral
        )
    )
    cryptoCurrencies.add(
        CryptoCurrency(
            icon = R.drawable.ic_coin_xzc,
            name = "ZCoin",
            value = "$1.584.03",
            code = "XZC",
            changes = "-23.00%",
            changesColor = Coral
        )
    )
    cryptoCurrencies.add(
        CryptoCurrency(
            icon = R.drawable.ic_coin_enj,
            name = "Enjin",
            value = "$483.23",
            code = "ENJ",
            changes = "+50.43%",
            changesColor = Green
        )
    )
    return cryptoCurrencies
}

data class StockChartItem(
    val date: LocalDateTime,
    val close: Double
)

@RequiresApi(Build.VERSION_CODES.O)
fun getStockChartInfo(): List<StockChartItem> {
    val stockChartInfo = mutableListOf<StockChartItem>()
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.JANUARY, 15, 3, 15),
            close = 15.3
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.FEBRUARY, 15, 3, 15),
            close = 20.2
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.MARCH, 15, 3, 15),
            close = 10.23
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.APRIL, 15, 3, 15),
            close = 50.32
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.MAY, 15, 3, 15),
            close = 6.3
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.JUNE, 15, 3, 15),
            close = 6.4
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.JULY, 15, 3, 15),
            close = 34.2
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.AUGUST, 15, 3, 15),
            close = 2.3
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.SEPTEMBER, 15, 3, 15),
            close = 10.5
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.OCTOBER, 15, 3, 15),
            close = 32.3
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.NOVEMBER, 15, 3, 15),
            close = 5.0
        )
    )
    stockChartInfo.add(
        StockChartItem(
            date = LocalDateTime.of(2016, Month.DECEMBER, 15, 3, 15),
            close = 10.2
        )
    )

    return stockChartInfo
}