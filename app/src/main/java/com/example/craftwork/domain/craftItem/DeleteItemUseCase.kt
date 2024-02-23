package com.example.craftwork.domain.craftItem

class DeleteItemUseCase(private val itemListRepository: ItemListRepository) {
    fun deleteItem(craftItem: CraftItem) {
        itemListRepository.deleteCraftItem(craftItem)
    }
}