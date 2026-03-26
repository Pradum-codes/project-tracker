package com.example.projecttracker.data.repository

import com.example.projecttracker.data.db.NoteDao
import com.example.projecttracker.data.model.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {
    val notes: Flow<List<NoteEntity>> = noteDao.observeNotes()

    suspend fun create(note: NoteEntity): Long = noteDao.insert(note)

    suspend fun update(note: NoteEntity) = noteDao.update(note)

    suspend fun delete(note: NoteEntity) = noteDao.delete(note)
}
