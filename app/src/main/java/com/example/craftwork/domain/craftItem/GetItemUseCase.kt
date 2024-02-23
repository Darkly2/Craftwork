package com.example.craftwork.domain.craftItem

class GetItemUseCase(private val itemListRepository: ItemListRepository) {
    fun getItem(id: String): CraftItem {
        return itemListRepository.getCraftItem(id)
    }
}