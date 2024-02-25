package com.example.craftwork.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.craftwork.domain.craftItem.CraftItem
import com.example.craftwork.domain.craftItem.ItemListRepository

object ItemListRepositoryImpl : ItemListRepository {

    private val craftItemLivedata = MutableLiveData<List<CraftItem>>()

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
            Log.d("addNewItem", generatedId.toString())
        }
        craftItemList.add(craftItem)
        updateLiveData()
    }

    override fun deleteCraftItem(craftItem: CraftItem) {
        craftItemList.remove(craftItem)
        updateLiveData()
    }

    override fun editCraftItem(craftItem: CraftItem) {
        val oldItem = getCraftItem(craftItem.id)
        craftItemList.remove(craftItem)
        addNewItem(craftItem)
    }

    override fun getCraftItemList(): LiveData<List<CraftItem>> {
        return craftItemLivedata
    }

    override fun getCraftItem(id: String): CraftItem {
        return craftItemList.find {
            it.id == id
        } ?: throw RuntimeException("Element $id is not found")
    }

    private fun updateLiveData() {
        craftItemLivedata.value = craftItemList.toList()
    }
}