package com.example.craftwork.domain.craftItem

class EditItemUseCase(private val itemListRepository: ItemListRepository) {
    fun editItem(craftItem: CraftItem) {
        itemListRepository.deleteCraftItem(craftItem)
    }
}