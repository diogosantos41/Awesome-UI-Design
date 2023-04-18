package com.dscoding.awesomeuidesign.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val GreyDark = Color(0xFF333333)
val GreyLight = Color(0xFFEEEEEE)
val WhiteDirty = Color(0xFFF0F3F4)

val PurpleDark = Color(0xFF312b47)
val Purple = Color(0xFF653ff4)
val Green = Color(0xFF28B463)
val GreenDark = Color(0xFF00512C)
val Coral = Color(0xFFFF7F50)

// Speed Test

val Coral1 = Color(0xFFFF7CAD) // Green200
val Coral2 = Color(0xFFFF7F82) //Green300

val DarkColor = Color(0xFF101522)
val DarkColor2 = Color(0xFF202532)
val LightColor = Color(0xFF414D66)
val LightColor2 = Color(0xFF626F88)

val CoralGradient = Brush.linearGradient(
    colors = listOf(Coral2, Coral1),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val DarkGradient = Brush.verticalGradient(
    colors = listOf(DarkColor2, DarkColor)
)
