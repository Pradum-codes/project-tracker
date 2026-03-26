package com.example.projecttracker

import com.example.projecttracker.util.projectColor
import org.junit.Assert.assertEquals
import org.junit.Test
import androidx.compose.ui.graphics.Color

class ProjectColorsTest {
    @Test
    fun projectColor_isDeterministicForSeed() {
        val expected = Color(0xFF4E6AF3)
        assertEquals(expected, projectColor(0L))
    }
}
