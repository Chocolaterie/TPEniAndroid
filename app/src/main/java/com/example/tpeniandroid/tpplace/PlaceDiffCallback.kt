package com.example.tpeniandroid.tpplace

import androidx.recyclerview.widget.DiffUtil

class PlaceDiffCallback : DiffUtil.ItemCallback<Place>() {

    override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
        return oldItem.equals(newItem)
    }
}