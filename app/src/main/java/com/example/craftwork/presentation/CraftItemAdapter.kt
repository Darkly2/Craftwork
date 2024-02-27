package com.example.craftwork.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.craftwork.databinding.CraftItemBinding
import com.example.craftwork.domain.craftItem.CraftItem

class CraftItemAdapter : ListAdapter<CraftItem, CraftItemViewHolder>(CraftItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraftItemViewHolder {
        val binding = CraftItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        return CraftItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CraftItemViewHolder, position: Int) {
        holder.
    }

}