package com.eneselcuk.daynote.ui.fragment.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.daynote.R
import com.eneselcuk.daynote.adapter.NoteAdapter
import com.eneselcuk.daynote.databinding.HomeFragmentBinding
import com.eneselcuk.daynote.ui.fragment.viewModel.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var rcAdapter: NoteAdapter

    private var binding: HomeFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcAdapter = NoteAdapter()

        binding?.apply {
            homeToWriteClick = this@HomeFragment
            lifecycleOwner = viewLifecycleOwner
            viewModel = homeViewModel
            recyclerView.adapter = rcAdapter
        }

        onClick()
        swipe()
    }

    fun click() {
        findNavController().navigate(R.id.action_homeFragment_to_noteWriteFragment)
    }

    private fun onClick() {
        rcAdapter.onClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                it))
        }
    }

    private fun swipe() {
        val swipe = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val noteData = rcAdapter.currentList[position]
                homeViewModel.deleteNote(noteData.id)

                view?.let {
                    Snackbar.make(it, "deleted", Snackbar.LENGTH_SHORT).apply {
                        setAction("undo") {
                            homeViewModel.addNote(noteData)
                            rcAdapter.notifyDataSetChanged()
                        }
                        show()
                    }
                }
            }
        }

        ItemTouchHelper(swipe).apply {
            attachToRecyclerView(binding?.recyclerView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        rcAdapter.notifyDataSetChanged()
    }
}