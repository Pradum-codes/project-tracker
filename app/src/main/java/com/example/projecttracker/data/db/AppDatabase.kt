package com.example.projecttracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projecttracker.data.model.NoteEntity
import com.example.projecttracker.data.model.ProjectEntity
import com.example.projecttracker.data.model.TaskEntity

@Database(
    entities = [ProjectEntity::class, TaskEntity::class, NoteEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao
}
