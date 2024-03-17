package com.example.craftwork.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.craftwork.data.ItemListRepositoryImpl
import com.example.craftwork.domain.craftItem.AddNewItemUseCase
import com.example.craftwork.domain.craftItem.CraftItem
import com.example.craftwork.domain.craftItem.EditItemUseCase
import com.example.craftwork.domain.craftItem.GetItemUseCase

class CraftItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ItemListRepositoryImpl

    private val addNewItemUseCase = AddNewItemUseCase(repository)
    private val getItemUseCase = GetItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)

    fun addNewItem(
        inputName: String?,
        inputCraftType: String?,
        inputDescription: String?) {
        val name = parseInput(inputName)
        val craftType = parseInput(inputCraftType)
        val description = parseInput(inputDescription)
        val item = CraftItem(name, craftType, description)
        addNewItemUseCase.addNewItem(item)
    }

    fun getItem(id: String): CraftItem {
        return getItemUseCase.getItem(id)
    }

    fun editItem(craftItem: CraftItem) {
        val newItem = craftItem.copy()
        editItemUseCase.editItem(newItem)
    }

    private fun parseInput(input: String?): String {
        return input?.trim() ?: ""
    }

}