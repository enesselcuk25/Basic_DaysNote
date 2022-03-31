package com.eneselcuk.daynote.bindingsAdapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.daynote.adapter.NoteAdapter
import com.eneselcuk.daynote.model.NoteData


@BindingAdapter("app:listAdapter")
fun bindRecyclerView(recyclerView: RecyclerView, noteData: List<NoteData>?) {
    val adapter = recyclerView.adapter as NoteAdapter
    adapter.submitList(noteData)
}

