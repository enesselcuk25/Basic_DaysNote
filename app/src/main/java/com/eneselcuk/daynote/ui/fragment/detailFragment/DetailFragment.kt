package com.eneselcuk.daynote.ui.fragment.detailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eneselcuk.daynote.R
import com.eneselcuk.daynote.databinding.FragmentDetailBinding
import com.eneselcuk.daynote.model.NoteData
import com.eneselcuk.daynote.ui.fragment.viewModel.HomeViewModel
import com.eneselcuk.daynote.util.DataFormat.dayToday


class DetailFragment : Fragment() {
    private var binding: FragmentDetailBinding? = null
    private val safeArgs: DetailFragmentArgs by navArgs()
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            backClick = this@DetailFragment
            safeArgs.noteDetail.let { noteDatas ->
                noteData = noteDatas
            }
        }
    }

    fun clickBack() {
        findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
    }

    fun updateClick() {
        val noteDatas = NoteData(title = binding?.edittextDetailTitle?.text.toString(),
            content = binding?.edittextDetailContent?.text.toString(),
            time = dayToday, id = safeArgs.noteDetail.id
//            , backround = R.color.white
        )
        binding?.noteData = noteDatas
        viewModel.updateNote(noteDatas)
        findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
    }
}