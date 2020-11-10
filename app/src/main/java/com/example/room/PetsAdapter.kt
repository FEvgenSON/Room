package com.example.room

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.room.entity.Pet

class PetsAdapter(
    private val viewModel: OwnerViewModel
) : ListAdapter<Pet, PetViewHolder>(diffCallback) {

    init {
        setHasStableIds(true)
    }

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Pet>() {

            override fun areItemsTheSame(
                oldItem: Pet,
                newItem: Pet
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Pet,
                newItem: Pet
            ): Boolean = oldItem == newItem
        }
    }

    override fun getItemId(position: Int): Long = getItem(position).id

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PetViewHolder = PetViewHolder.from(parent, viewModel)

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}