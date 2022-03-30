package com.eneselcuk.daynote.data

import androidx.room.*
import com.eneselcuk.daynote.model.NoteData

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_data")
    suspend fun allNote(): List<NoteData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(noteData: NoteData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun swipeAddNote(noteData: NoteData):Long

    @Query("DELETE FROM note_data WHERE id = :key  ")
    suspend fun delete(key: Int)

    @Update
    suspend fun update(noteData: NoteData)


}