package com.example.craftwork.domain.craftItem

import androidx.lifecycle.LiveData

interface ItemListRepository {
    fun addNewItem(craftItem: CraftItem)
    fun deleteCraftItem(craftItem: CraftItem)
    fun editCraftItem(craftItem: CraftItem)
    fun getCraftItemList(): LiveData<List<CraftItem>>
    fun getCraftItem(id: String): CraftItem

}