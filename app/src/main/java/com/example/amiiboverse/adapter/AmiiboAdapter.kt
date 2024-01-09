package com.example.amiiboverse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amiiboverse.databinding.ListViewItemBinding
import com.example.amiiboverse.newtork.Character

class AmiiboAdapter(val clickListener: AmiiboListener):
    ListAdapter<Character, AmiiboAdapter.AmiiboViewHolder>(DiffCallback){

    class AmiiboViewHolder(
        var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(clickListener: AmiiboListener, amiibo: Character) {
                binding.character = amiibo
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback: DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.image == newItem.image && oldItem.character == newItem.character
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AmiiboViewHolder(ListViewItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: AmiiboViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(clickListener ,character)
    }
}

class AmiiboListener(val clickListener: (amiibo: Character) -> Unit) {
    fun onClick(amiibo: Character) = clickListener(amiibo)
}