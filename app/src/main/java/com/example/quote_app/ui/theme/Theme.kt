package com.example.quote_app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Custom colors for the Quote theme
//light Theme Colors
val QuoteBackgroundLight = Color(0xFFf2f2f2)
val QuotePrimaryLight = Color(0xFF6200EE)
val QuoteSecondaryLight = Color(0xFF03DAC5)
val QuoteOnPrimaryLight = Color.White

//dark Theme Colors
val QuoteBackgroundDark = Color(0xFF121212)
val QuotePrimaryDark = Color(0xFFBB86FC)
val QuoteSecondaryDark = Color(0xFF03DAC5)
val QuoteOnPrimaryDark = Color.Black
val QuoteOnBackgroundDark = Color.White

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
        color = QuotePrimaryLight
    )
)

@Composable
fun Quote_AppTheme(
    content: @Composable () -> Unit
) {
    //get the current system theme
    val isDarkTheme = isSystemInDarkTheme()

    // Set the appropriate color scheme for light or dark theme
    val colors = if (isDarkTheme) {
        darkColorScheme(
            primary = QuotePrimaryDark,
            secondary = QuoteSecondaryDark,
            background = QuoteBackgroundDark,
            onPrimary = QuoteOnPrimaryDark,
            onBackground = QuoteOnBackgroundDark
        )
    } else {
        lightColorScheme(
            primary = QuotePrimaryLight,
            secondary = QuoteSecondaryLight,
            background = QuoteBackgroundLight,
            onPrimary = QuoteOnPrimaryLight,
            onBackground = Color.Black
        )
    }

    //apply the selected color scheme and typography to the theme
    MaterialTheme(
        colorScheme = colors,
        typography = QuoteTypography,
        content = content
    )
}
