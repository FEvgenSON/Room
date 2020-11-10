package com.example.room

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.room.entity.Owner

class MainOwnerAdapter(
    private val viewModel: MainViewModel
) : ListAdapter<Owner, OwnerViewHolder>(diffCallback) {

    init {
        setHasStableIds(true)
    }

    private companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Owner>() {

            override fun areItemsTheSame(
                oldItem: Owner,
                newItem: Owner
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Owner,
                newItem: Owner
            ): Boolean = oldItem == newItem
        }
    }

    override fun getItemId(position: Int): Long = getItem(position).id

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OwnerViewHolder = OwnerViewHolder.from(parent, viewModel)

    override fun onBindViewHolder(holder: OwnerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}