package com.example.projecttracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttracker.data.model.ProjectEntity
import com.example.projecttracker.data.repository.ProjectRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.launch

class ProjectsViewModel(
    private val projectRepository: ProjectRepository
) : ViewModel() {
    val projects: StateFlow<List<ProjectEntity>> = projectRepository.projects
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun createProject(name: String, description: String, colorSeed: Long, dueAt: Long?) {
        val trimmedName = name.trim()
        val trimmedDescription = description.trim()
        if (trimmedName.isBlank()) return

        val project = ProjectEntity(
            name = trimmedName,
            description = trimmedDescription,
            colorSeed = colorSeed,
            createdAt = System.currentTimeMillis(),
            dueAt = dueAt
        )
        viewModelScope.launch {
            projectRepository.create(project)
        }
    }

    fun deleteProject(project: ProjectEntity) {
        viewModelScope.launch {
            projectRepository.delete(project)
        }
    }
}
