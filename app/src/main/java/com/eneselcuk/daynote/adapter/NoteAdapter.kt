package com.eneselcuk.daynote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.eneselcuk.daynote.R
import com.eneselcuk.daynote.model.NoteData

class NoteAdapter(var clickListener: DayClickListener) : ListAdapter<NoteData,
        MyViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.view_item_notes,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myPosition = getItem(position)
        holder.bind(myPosition, clickListener)

    }

    class DayClickListener(var clickListener: (noteData: NoteData) -> Unit) {
        fun onClick(noteDay: NoteData) = clickListener(noteDay)
    }
}


