package com.example.projecttracker.ui.navigation

object Routes {
    const val PROJECTS = "projects"
    const val CREATE_PROJECT = "create_project"
    const val PROJECT_DETAILS = "project_details"
    const val POMODORO = "pomodoro"
    const val NOTES = "notes"

    fun projectDetails(projectId: Long): String = "$PROJECT_DETAILS/$projectId"
}
