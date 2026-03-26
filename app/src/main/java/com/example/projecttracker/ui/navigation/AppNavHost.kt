package com.example.projecttracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import com.example.projecttracker.data.repository.NoteRepository
import com.example.projecttracker.data.repository.ProjectRepository
import com.example.projecttracker.data.repository.TaskRepository
import com.example.projecttracker.ui.screens.PomodoroScreen
import com.example.projecttracker.ui.screens.NotesScreen
import com.example.projecttracker.ui.screens.details.ProjectDetailScreen
import com.example.projecttracker.ui.screens.projects.ProjectFormScreen
import com.example.projecttracker.ui.screens.projects.ProjectsScreen
import com.example.projecttracker.viewmodel.ProjectDetailViewModel
import com.example.projecttracker.viewmodel.ProjectDetailViewModelFactory
import com.example.projecttracker.viewmodel.NotesViewModel
import com.example.projecttracker.viewmodel.NotesViewModelFactory
import com.example.projecttracker.viewmodel.ProjectsViewModel
import com.example.projecttracker.viewmodel.ProjectsViewModelFactory

@Composable
fun AppNavHost(
    navController: NavHostController,
    projectRepository: ProjectRepository,
    taskRepository: TaskRepository,
    noteRepository: NoteRepository,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController, 
        startDestination = Routes.PROJECTS,
        modifier = modifier
    ) {
        composable(Routes.PROJECTS) {
            val viewModel: ProjectsViewModel = viewModel(
                factory = ProjectsViewModelFactory(projectRepository)
            )
            ProjectsScreen(
                viewModel = viewModel,
                onAddProject = { navController.navigate(Routes.CREATE_PROJECT) },
                onOpenProject = { projectId: Long ->
                    navController.navigate(Routes.projectDetails(projectId))
                }
            )
        }

        composable(Routes.POMODORO) {
            PomodoroScreen()
        }
        
        composable(Routes.NOTES) {
            val viewModel: NotesViewModel = viewModel(
                factory = NotesViewModelFactory(noteRepository)
            )
            NotesScreen(viewModel = viewModel)
        }

        composable(Routes.CREATE_PROJECT) {
            val viewModel: ProjectsViewModel = viewModel(
                factory = ProjectsViewModelFactory(projectRepository)
            )
            ProjectFormScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = "${Routes.PROJECT_DETAILS}/{projectId}",
            arguments = listOf(navArgument("projectId") { type = NavType.LongType })
        ) { backStackEntry: NavBackStackEntry ->
            val projectId = backStackEntry.arguments?.getLong("projectId") ?: return@composable
            val viewModel: ProjectDetailViewModel = viewModel(
                factory = ProjectDetailViewModelFactory(
                    projectRepository = projectRepository,
                    taskRepository = taskRepository,
                    projectId = projectId
                )
            )
            ProjectDetailScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onProjectDeleted = {
                    navController.popBackStack(Routes.PROJECTS, inclusive = false)
                }
            )
        }
    }
}
