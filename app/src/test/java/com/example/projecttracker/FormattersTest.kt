package com.example.projecttracker

import com.example.projecttracker.util.formatShortDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.TimeZone

class FormattersTest {
    @Test
    fun formatShortDate_usesExpectedPatternInUtc() {
        val originalZone = TimeZone.getDefault()
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
            val epochMillis = 1705276800000L // 2024-01-15T00:00:00Z
            val formatted = formatShortDate(epochMillis)
            assertEquals("Jan 15, 2024", formatted)
        } finally {
            TimeZone.setDefault(originalZone)
        }
    }
}
