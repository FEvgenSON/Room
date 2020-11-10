package com.example.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.room.databinding.FragmentMainBinding
import com.example.room.entity.Owner
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        with(binding) {
            add.setOnClickListener {
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            save.setOnClickListener {
                val owner = Owner(
                    name = name.text.toString(),
                    age = age.text.toString().toInt()
                )
                viewModel.addOwner(owner)
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            val adapter = MainOwnerAdapter(viewModel)
            recyclerView.adapter = adapter
            viewModel.owners.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}