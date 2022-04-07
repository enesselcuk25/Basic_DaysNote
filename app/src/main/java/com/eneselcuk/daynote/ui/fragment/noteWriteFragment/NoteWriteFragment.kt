package com.eneselcuk.daynote.ui.fragment.noteWriteFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.eneselcuk.daynote.R
import com.eneselcuk.daynote.databinding.WriteFragmentBinding
import com.eneselcuk.daynote.model.NoteData
import com.eneselcuk.daynote.ui.fragment.viewModel.HomeViewModel
import com.eneselcuk.daynote.util.DataFormat
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteWriteFragment : Fragment() {
    private var binding: WriteFragmentBinding? = null

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.write_fragment, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            writeFragment = this@NoteWriteFragment
        }
    }

    fun addClick() {
        val noteDatas = NoteData(
            id = 0, title = binding?.edittext?.text.toString(),
            content = binding?.edittextDetail?.text.toString(),
            time = DataFormat.dayToday
        )
        binding?.noteData = noteDatas
        viewModel.addNote(noteDatas)
        findNavController().navigate(R.id.action_noteWriteFragment_to_homeFragment)
    }

    fun backClick() {
        findNavController().navigate(R.id.action_noteWriteFragment_to_homeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}