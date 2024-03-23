package com.example.craftwork.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.ListAdapter
import com.example.craftwork.R
import com.example.craftwork.databinding.CraftItemBinding
import com.example.craftwork.domain.craftItem.CraftItem

class CraftItemAdapter : ListAdapter<CraftItem, CraftItemViewHolder>(CraftItemCallback()) {

    var onItemClickListener: ((CraftItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraftItemViewHolder {
        val binding = CraftItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        return CraftItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CraftItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.imageViewCraftItem.setImageDrawable(android.R.drawable.btn_star.toDrawable())
        holder.binding.textViewCraftItemName.text = item.name
        holder.binding.textViewCraftItemType.text = item.craftType

        holder.binding.root.setOnClickListener  {
            onItemClickListener?.invoke(item)
        }
    }

}