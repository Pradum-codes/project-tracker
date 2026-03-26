package com.example.projecttracker.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue

private val shortDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")

fun formatShortDate(epochMillis: Long): String {
    val instant = Instant.ofEpochMilli(epochMillis)
    val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
    return shortDateFormatter.format(localDate)
}

fun formatRelativeTime(epochMillis: Long, nowMillis: Long = System.currentTimeMillis()): String {
    val diff = (nowMillis - epochMillis).absoluteValue
    val minute = 60_000L
    val hour = 60 * minute
    val day = 24 * hour
    return when {
        diff < minute -> "just now"
        diff < hour -> "${diff / minute}m ago"
        diff < day -> "${diff / hour}h ago"
        diff < 7 * day -> "${diff / day}d ago"
        else -> formatShortDate(epochMillis)
    }
}
