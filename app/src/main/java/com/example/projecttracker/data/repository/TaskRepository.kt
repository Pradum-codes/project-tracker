package com.example.projecttracker.data.repository

import com.example.projecttracker.data.db.TaskDao
import com.example.projecttracker.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    fun tasks(projectId: Long): Flow<List<TaskEntity>> = taskDao.observeTasks(projectId)

    suspend fun create(task: TaskEntity): Long = taskDao.insert(task)

    suspend fun update(task: TaskEntity) = taskDao.update(task)

    suspend fun delete(task: TaskEntity) = taskDao.delete(task)

    suspend fun deleteByProject(projectId: Long) = taskDao.deleteByProject(projectId)
}
