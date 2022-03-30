package com.eneselcuk.daynote.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "note_data")
@Parcelize
data class NoteData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,

    ): Parcelable


