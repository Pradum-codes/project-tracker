package com.example.projecttracker.data.repository

import com.example.projecttracker.data.db.NotesDao
import com.example.projecttracker.data.model.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(
    private val notesDao: NotesDao
) {
    fun getAllNotes(): Flow<List<Note>> {
        return notesDao.getAllNotes()
    }

    suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    suspend fun updateNote(note: Note) {
        notesDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    fun getNoteById(noteId: Int): Flow<Note?> {
        return notesDao.getNoteById(noteId)
    }
}
