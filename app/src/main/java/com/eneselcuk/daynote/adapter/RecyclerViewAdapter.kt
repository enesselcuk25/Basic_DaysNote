package com.eneselcuk.daynote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.daynote.R
import com.eneselcuk.daynote.databinding.ViewItemNotesBinding
import com.eneselcuk.daynote.model.NoteData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyAdapter>() {
    class MyAdapter(private val binding: ViewItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteData: NoteData) {
            binding.noteTexts = noteData
        }
    }

     var listNote: List<NoteData> = arrayListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerViewAdapter.MyAdapter {
        return MyAdapter(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.view_item_notes,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyAdapter, position: Int) {
        val myPosition = listNote[position]
        holder.bind(myPosition)
    }

    override fun getItemCount(): Int = listNote.size

}