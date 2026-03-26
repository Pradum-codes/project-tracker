package com.example.projecttracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projecttracker.data.model.NoteEntity
import com.example.projecttracker.data.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel(
    private val noteRepository: NoteRepository
) : ViewModel() {
    val notes: StateFlow<List<NoteEntity>> = noteRepository.notes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun createNote(label: String, title: String, content: String) {
        val safeTitle = title.trim()
        val safeContent = content.trim()
        if (safeTitle.isBlank() || safeContent.isBlank()) return

        val now = System.currentTimeMillis()
        val note = NoteEntity(
            label = label.trim().ifBlank { "General" },
            title = safeTitle,
            content = safeContent,
            createdAt = now,
            updatedAt = now
        )

        viewModelScope.launch {
            noteRepository.create(note)
        }
    }

    fun updateNote(note: NoteEntity, label: String, title: String, content: String) {
        val safeTitle = title.trim()
        val safeContent = content.trim()
        if (safeTitle.isBlank() || safeContent.isBlank()) return

        val updated = note.copy(
            label = label.trim().ifBlank { note.label },
            title = safeTitle,
            content = safeContent,
            updatedAt = System.currentTimeMillis()
        )
        viewModelScope.launch {
            noteRepository.update(updated)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.delete(note)
        }
    }
}
