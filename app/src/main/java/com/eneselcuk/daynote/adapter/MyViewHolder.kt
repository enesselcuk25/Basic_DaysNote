package com.eneselcuk.daynote.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.daynote.databinding.ViewItemNotesBinding
import com.eneselcuk.daynote.model.NoteData

class MyViewHolder(private val binding: ViewItemNotesBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        noteData: NoteData,
        onClickListener: NoteAdapter.DayClickListener
    ) {
        binding.noteTexts = noteData
        binding.click = onClickListener
        binding.executePendingBindings()

    }
}