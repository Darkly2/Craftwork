package com.example.craftwork.domain.craftItem

class AddNewItemUseCase(private val itemListRepository: ItemListRepository) {
    fun addNewItem(craftItem: CraftItem) {
        itemListRepository.addNewItem(craftItem)
    }
}