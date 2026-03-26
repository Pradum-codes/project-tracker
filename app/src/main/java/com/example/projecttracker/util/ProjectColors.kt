package com.example.projecttracker.util

import androidx.compose.ui.graphics.Color

private val palette = listOf(
    Color(0xFF4E6AF3),
    Color(0xFF3F8E7D),
    Color(0xFFF39C5A),
    Color(0xFFD96C75),
    Color(0xFF7B5EA7),
    Color(0xFF4B8BD9),
    Color(0xFF6D9E3F)
)

fun projectColor(seed: Long): Color {
    if (palette.isEmpty()) return Color(0xFF4E6AF3)
    val index = kotlin.math.abs(seed).toInt() % palette.size
    return palette[index]
}
