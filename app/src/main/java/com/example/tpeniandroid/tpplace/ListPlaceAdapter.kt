package com.example.tpeniandroid.tpplace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tpeniandroid.databinding.PlaceRowStyleBinding

class ListPlaceAdapter : ListAdapter<Place, ListPlaceAdapter.ViewHolder>(PlaceDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder(val binding: PlaceRowStyleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Place) {
            binding.place = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ListPlaceAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PlaceRowStyleBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}