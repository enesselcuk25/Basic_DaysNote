package com.eneselcuk.daynote.ui.fragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eneselcuk.daynote.model.NoteData
import com.eneselcuk.daynote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private val _noteData: MutableLiveData<List<NoteData>> = MutableLiveData()
    val notaData: LiveData<List<NoteData>>
        get() = _noteData

    private val _click: MutableLiveData<NoteData?> = MutableLiveData()
    val click: LiveData<NoteData?>
        get() = _click

    init {
        allNote()
    }

    fun allNote() {
        viewModelScope.launch {
            _noteData.value = repository.getAll()
        }
    }

    fun addNote(noteData: NoteData) {
        viewModelScope.launch {
            repository.addNote(noteData)
        }
    }

    fun deleteNote(key: Int) {
        viewModelScope.launch {
            repository.deleteNote(key)
        }
    }

    fun updateNote(noteData: NoteData) {
        viewModelScope.launch {
            repository.updateNote(noteData)
        }
    }

    fun onClickListener(noteData: NoteData) {
        _click.postValue(noteData)
    }

    fun onClickNavigated() {
        _click.postValue(null)
    }


}