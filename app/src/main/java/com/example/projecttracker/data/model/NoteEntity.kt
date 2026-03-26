package com.example.projecttracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val label: String,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long
)
