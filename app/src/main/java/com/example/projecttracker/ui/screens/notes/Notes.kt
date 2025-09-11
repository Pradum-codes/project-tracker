package com.example.projecttracker.ui.screens.notes

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.animation.AnimatedVisibility
import com.example.projecttracker.data.model.Note
import com.example.projecttracker.viewmodel.NotesViewModel

@Composable
fun Notes(viewModel: NotesViewModel) {
    val notes by viewModel.allNotes.collectAsState(initial = emptyList())
    var selectedNote by remember { mutableStateOf<Note?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        NotesList(
            notes = notes,
            onNoteClick = { note -> selectedNote = note }
        )

        FloatingActionButton(
            onClick = {
                selectedNote = Note(id = 0, title = "", content = "", timestamp = System.currentTimeMillis())
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Note")
        }

        AnimatedVisibility(visible = selectedNote != null) {
            selectedNote?.let { note ->
                NoteEditDialog(
                    note = note,
                    onDismiss = { selectedNote = null },
                    onSave = { updatedNote ->
                        if (updatedNote.id == 0) {
                            viewModel.insertNote(updatedNote.copy(id = 0))
                        } else {
                            viewModel.updateNote(updatedNote)
                        }
                        selectedNote = null
                    }
                )
            }
        }
    }
}