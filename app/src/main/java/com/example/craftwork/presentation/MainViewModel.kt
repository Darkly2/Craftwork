package com.example.craftwork.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.craftwork.data.ItemListRepositoryImpl
import com.example.craftwork.domain.craftItem.CraftItem
import com.example.craftwork.domain.craftItem.EditItemUseCase
import com.example.craftwork.domain.craftItem.GetItemListUseCase
import com.example.craftwork.domain.craftItem.GetItemUseCase

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ItemListRepositoryImpl

    private val getItemListUseCase = GetItemListUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)
    private val getItemUseCase = GetItemUseCase(repository)

    val craftItemList = getItemListUseCase.getItemList()

    fun getItem(craftItem: CraftItem) {
        getItemUseCase.getItem(craftItem.id)
    }
    fun editItem(craftItem: CraftItem) {
        val newItem = craftItem.copy()
        editItemUseCase.editItem(newItem)
    }

}