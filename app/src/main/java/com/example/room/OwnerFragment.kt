package com.example.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.room.databinding.FragmentOwnerBinding
import com.example.room.entity.Pet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class OwnerFragment : Fragment() {

    private var _binding: FragmentOwnerBinding? = null
    private val binding: FragmentOwnerBinding
        get() = _binding!!

    private val viewModel by viewModel<OwnerViewModel> {
        parametersOf(arguments?.getLong("ownerId"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOwnerBinding.inflate(inflater, container, false)

        with(binding) {
            add.setOnClickListener {
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            save.setOnClickListener {
                val pet = Pet(
                    name = nameEditText.text.toString(),
                    age = ageEditText.text.toString().toInt()
                )
                viewModel.addPet(pet)
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            val adapter = PetsAdapter(viewModel)
            recyclerView.adapter = adapter
            viewModel.ownerWithPets.observe(viewLifecycleOwner) {
                adapter.submitList(it.pets)
            }
            viewModel.ownerWithPets.observe(viewLifecycleOwner) { ownerWithPets ->
                with(owner) {
                    id.text = ownerWithPets.owner.ownerId.toString()
                    name.text = ownerWithPets.owner.name
                    age.text = ownerWithPets.owner.age.toString()
                }
            }
        }

        return binding.root
    }
}