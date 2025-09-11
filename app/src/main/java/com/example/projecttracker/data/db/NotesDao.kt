package com.example.projecttracker.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.example.projecttracker.data.model.Note

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :noteId LIMIT 1")
    fun getNoteById(noteId: Int): Flow<Note?>
}
