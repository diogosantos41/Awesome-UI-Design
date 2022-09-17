package com.dscoding.awesomeuidesign.feature_crypto_currency

import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.ui.theme.GreyDark
import java.lang.Math.round
import kotlin.math.roundToInt


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CryptoCurrencyScreen() {
    val horizontalPadding = 16.dp

    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(start = horizontalPadding)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            Modifier
                .size(45.dp)
                .background(
                    color = GreyDark,
                    shape = RoundedCornerShape(30.dp),
                )
                .padding(5.dp)
        ) {
            Image(
                imageVector = Icons.Default.ArrowBack,
                colorFilter = ColorFilter.tint(White),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Portfolio", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            Modifier.fillMaxWidth()
        ) {
            items(getCryptoCurrencies()) { cryptoCurrency ->
                PortfolioItem(
                    icon = ImageVector.vectorResource(id = cryptoCurrency.icon),
                    name = cryptoCurrency.name,
                    value = cryptoCurrency.value,
                    code = cryptoCurrency.code,
                    changes = cryptoCurrency.changes,
                    changesColor = cryptoCurrency.changesColor,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Profit & Loss", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))
        StockChart(
            stockChartInfo = getStockChartInfo(),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(CenterHorizontally)
        )
    }
}

@Composable
fun PortfolioItem(
    icon: ImageVector,
    name: String,
    value: String,
    code: String,
    changes: String,
    changesColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = GreyDark,
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .width(180.dp)
    ) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.Center) {
            Image(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = name, color = White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    backgroundColor = changesColor,
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = changes,
                        color = White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, color = White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = code, color = Gray, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockChart(
    stockChartInfo: List<StockChartItem> = emptyList(),
    modifier: Modifier = Modifier,
    graphColor: Color = White
) {
    val spacing = 100f
    val transparentGraphColor = remember {
        graphColor.copy(alpha = 0.5f)
    }
    val upperValue = remember(stockChartInfo) {
        (stockChartInfo.maxOfOrNull { it.close }?.plus(1))?.roundToInt() ?: 0
    }
    val lowerValue = remember(stockChartInfo) {
        stockChartInfo.minOfOrNull { it.close }?.toInt() ?: 0
    }
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }
    Card(
        backgroundColor = GreyDark,
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp
    ) {
        Canvas(modifier = modifier) {
            val spacePerHour = (size.width - spacing) / stockChartInfo.size
            (0 until stockChartInfo.size - 1 step 2).forEach { i ->
                val info = stockChartInfo[i]
                val hour = info.date.hour
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        hour.toString(),
                        spacing + i * spacePerHour,
                        size.height - 5,
                        textPaint
                    )
                }
            }
            val priceStep = (upperValue - lowerValue) / 5f
            (0..4).forEach { i ->
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        round(lowerValue + priceStep * i).toString(),
                        30f,
                        size.height - spacing - i * size.height / 5f,
                        textPaint
                    )
                }
            }
            var lastX = 0f
            val strokePath = Path().apply {
                val height = size.height
                for (i in stockChartInfo.indices) {
                    val info = stockChartInfo[i]
                    val nextInfo = stockChartInfo.getOrNull(i + 1) ?: stockChartInfo.last()
                    val leftRatio = (info.close - lowerValue) / (upperValue - lowerValue)
                    val rightRatio = (nextInfo.close - lowerValue) / (upperValue - lowerValue)

                    val x1 = spacing + i * spacePerHour
                    val y1 = height - spacing - (leftRatio * height).toFloat()
                    val x2 = spacing + (i + 1) * spacePerHour
                    val y2 = height - spacing - (rightRatio * height).toFloat()
                    if (i == 0) {
                        moveTo(x1, y1)
                    }
                    lastX = (x1 + x2) / 2f
                    quadraticBezierTo(
                        x1, y1, lastX, (y1 + y2) / 2f
                    )
                }
            }
            val fillPath = android.graphics.Path(strokePath.asAndroidPath())
                .asComposePath()
                .apply {
                    lineTo(lastX, size.height - spacing)
                    lineTo(spacing, size.height - spacing)
                    close()
                }
            drawPath(
                path = fillPath,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        transparentGraphColor,
                        Color.Transparent
                    ),
                    endY = size.height - spacing
                )
            )
            drawPath(
                path = strokePath,
                color = graphColor,
                style = Stroke(
                    width = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        CryptoCurrencyScreen()
    }
}