package com.example.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.PetViewBinding
import com.example.room.entity.Pet

class PetViewHolder private constructor(
    private val binding: PetViewBinding,
    private val viewModel: OwnerViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun from(
            parent: ViewGroup,
            viewModel: OwnerViewModel
        ): PetViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = PetViewBinding.inflate(inflater, parent, false)
            return PetViewHolder(binding, viewModel)
        }
    }

    fun bind(pet: Pet) {
        binding.name.text = pet.name
        binding.age.text = pet.age.toString()
        binding.id.text = pet.id.toString()
        binding.ownerId.text = pet.ownerId.toString()
        binding.cardView.setOnLongClickListener {
            viewModel.deletePet(pet)
            true
        }
    }
}