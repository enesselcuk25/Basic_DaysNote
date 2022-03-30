package com.eneselcuk.daynote.adapter

import androidx.recyclerview.widget.DiffUtil
import com.eneselcuk.daynote.model.NoteData

val DiffUtilCallBack = object : DiffUtil.ItemCallback<NoteData>() {
    override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean  = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean  = oldItem == newItem

}