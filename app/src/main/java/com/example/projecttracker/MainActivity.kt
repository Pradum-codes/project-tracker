package com.example.projecttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.room.Room
import com.example.projecttracker.data.db.AppDatabase
import com.example.projecttracker.data.repository.NoteRepository
import com.example.projecttracker.data.repository.ProjectRepository
import com.example.projecttracker.data.repository.TaskRepository
import com.example.projecttracker.ui.ProjectTrackerApp
import com.example.projecttracker.ui.theme.ProjectTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "project_tracker.db"
        ).fallbackToDestructiveMigration(dropAllTables = true)
            .build()

        val projectRepository = ProjectRepository(database.projectDao())
        val taskRepository = TaskRepository(database.taskDao())
        val noteRepository = NoteRepository(database.noteDao())

        setContent {
            ProjectTrackerTheme {
                ProjectTrackerApp(
                    projectRepository = projectRepository,
                    taskRepository = taskRepository,
                    noteRepository = noteRepository
                )
            }
        }
    }
}
