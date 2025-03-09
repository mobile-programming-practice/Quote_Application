package com.example.quote_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//custom colors for the Quote theme
//for light bg
val QuoteBackground = Color(0xFFf2f2f2)
//deep purple for primary
val QuotePrimary = Color(0xFF6200EE)
val QuoteSecondary = Color(0xFF03DAC5)
val QuoteOnPrimary = Color.White

//typography for the Quote theme
val QuoteTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black

    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Color.Black
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = QuotePrimary
    )
)


@Composable
fun Quote_AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = QuotePrimary,
            secondary = QuoteSecondary,
            background = QuoteBackground,
            onPrimary = QuoteOnPrimary,
            onBackground = Color.Black
        ),
        typography = QuoteTypography,
        content = content
    )
}