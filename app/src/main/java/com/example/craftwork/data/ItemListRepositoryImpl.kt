package com.example.craftwork.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.craftwork.domain.craftItem.CraftItem
import com.example.craftwork.domain.craftItem.ItemListRepository

object ItemListRepositoryImpl : ItemListRepository {

    private val craftItemList = mutableListOf<CraftItem>()
    private var generatedId = 0

    init {
        for (num in 0..10) {
            val item = CraftItem("Name $num", "CraftType $num")
            addNewItem(item)
        }
    }
    override fun addNewItem(craftItem: CraftItem) {
        if (craftItem.id == CraftItem.UNDEFINED_ID) {
            craftItem.id = (++generatedId).toString()
        }
        craftItemList.add(craftItem)
    }

    override fun deleteCraftItem(craftItem: CraftItem) {
        craftItemList.remove(craftItem)
    }

    override fun editCraftItem(craftItem: CraftItem) {
        val oldItem = getCraftItem(craftItem.id)
        deleteCraftItem(oldItem)
        addNewItem(craftItem)
    }

    override fun getCraftItemList(): LiveData<List<CraftItem>> {
        return MutableLiveData(craftItemList)
    }

    override fun getCraftItem(id: String): CraftItem {
        return craftItemList.find {
            it.id == id
        } ?: throw RuntimeException("Element $id is not found")
    }
}