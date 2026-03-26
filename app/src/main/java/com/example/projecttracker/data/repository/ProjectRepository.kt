package com.example.projecttracker.data.repository

import com.example.projecttracker.data.db.ProjectDao
import com.example.projecttracker.data.model.ProjectEntity
import kotlinx.coroutines.flow.Flow

class ProjectRepository(private val projectDao: ProjectDao) {
    val projects: Flow<List<ProjectEntity>> = projectDao.observeProjects()

    fun project(projectId: Long): Flow<ProjectEntity?> = projectDao.observeProject(projectId)

    suspend fun create(project: ProjectEntity): Long = projectDao.insert(project)

    suspend fun update(project: ProjectEntity) = projectDao.update(project)

    suspend fun delete(project: ProjectEntity) = projectDao.delete(project)
}
