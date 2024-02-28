package com.example.craftwork.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.craftwork.domain.craftItem.CraftItem

class CraftItemCallback : DiffUtil.ItemCallback<CraftItem>() {
    override fun areItemsTheSame(
        oldItem: CraftItem,
        newItem: CraftItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CraftItem,
        newItem: CraftItem
    ): Boolean {
        return oldItem == newItem
    }


}