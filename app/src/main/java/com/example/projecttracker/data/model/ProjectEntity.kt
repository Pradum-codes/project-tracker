package com.example.projecttracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val description: String,
    val colorSeed: Long,
    val createdAt: Long,
    val dueAt: Long?
)
