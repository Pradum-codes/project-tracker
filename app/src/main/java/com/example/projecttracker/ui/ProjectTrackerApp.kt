package com.example.projecttracker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.projecttracker.data.repository.NoteRepository
import com.example.projecttracker.data.repository.ProjectRepository
import com.example.projecttracker.data.repository.TaskRepository
import com.example.projecttracker.ui.navigation.AppNavHost
import com.example.projecttracker.ui.navigation.BottomNavigationBar

@Composable
fun ProjectTrackerApp(
    projectRepository: ProjectRepository,
    taskRepository: TaskRepository,
    noteRepository: NoteRepository
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            projectRepository = projectRepository,
            taskRepository = taskRepository,
            noteRepository = noteRepository,
            modifier = Modifier.padding(paddingValues)
        )
    }
}
