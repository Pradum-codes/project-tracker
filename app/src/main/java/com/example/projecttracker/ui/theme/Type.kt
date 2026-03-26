package com.example.projecttracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projecttracker.R

private val RobotoMono = FontFamily(
    Font(R.font.roboto_mono_regular, FontWeight.Normal),
    Font(R.font.roboto_mono_medium, FontWeight.Medium),
    Font(R.font.roboto_mono_semibold, FontWeight.SemiBold),
    Font(R.font.roboto_mono_bold, FontWeight.Bold)
)

val ProjectTrackerTypography = Typography(

    headlineSmall = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.sp
    ),

    titleLarge = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),

    titleMedium = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),

    bodyLarge = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 14.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 12.sp
    ),

    labelLarge = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    )
)
