package com.eneselcuk.daynote.repository

import com.eneselcuk.daynote.data.NoteDao
import com.eneselcuk.daynote.model.NoteData
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun getAll() = noteDao.allNote()

    suspend fun addNote(noteData: NoteData) {
        noteDao.addNote(noteData)
    }

    suspend fun deleteNote(key:Int) = noteDao.delete(key)

    suspend fun updateNote(noteData: NoteData) = noteDao.update(noteData)

}