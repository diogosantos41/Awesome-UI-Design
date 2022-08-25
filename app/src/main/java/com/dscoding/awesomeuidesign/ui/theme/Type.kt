package com.dscoding.awesomeuidesign.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.dscoding.awesomeuidesign.R

val CustomFontFamily = FontFamily(
    Font(R.font.montserrat),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_medium, FontWeight.Medium)
)

val Typography = Typography(
    defaultFontFamily = CustomFontFamily
)

