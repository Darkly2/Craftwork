package com.example.craftwork.domain.craftItem

class EditItemUseCase(private val itemListRepository: ItemListRepository) {
    fun editItemUseCase(craftItem: CraftItem) {
        itemListRepository.deleteCraftItem(craftItem)
    }
}