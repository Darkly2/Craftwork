package com.example.craftwork.domain.craftItem

import androidx.lifecycle.LiveData

class GetItemListUseCase(private val itemListRepository: ItemListRepository) {
    fun getItemList(): LiveData<List<CraftItem>> {
        return itemListRepository.getCraftItemList()
    }
}