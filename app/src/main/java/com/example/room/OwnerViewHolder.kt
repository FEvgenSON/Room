package com.example.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.OwnerViewBinding
import com.example.room.entity.Owner

class OwnerViewHolder private constructor(
    private val binding: OwnerViewBinding,
    private val viewModel: MainViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun from(
            parent: ViewGroup,
            viewModel: MainViewModel
        ): OwnerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = OwnerViewBinding.inflate(inflater, parent, false)
            return OwnerViewHolder(binding, viewModel)
        }
    }

    fun bind(owner: Owner) {
        binding.name.text = owner.name
        binding.age.text = owner.age.toString()
        binding.id.text = owner.ownerId.toString()
        binding.cardView.setOnLongClickListener {
            viewModel.deleteOwner(owner)
            true
        }
        binding.cardView.setOnClickListener {
            itemView.findNavController().navigate(
                R.id.action_main_to_owner,
                Bundle().apply {
                    putLong("ownerId", owner.ownerId)
                }
            )
        }
    }
}