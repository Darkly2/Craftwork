package com.example.craftwork.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _errorNameValid = MutableLiveData<Boolean>()
    val errorNameValid: LiveData<Boolean>
        get() = _errorNameValid

    private val _errorCraftTypeValid = MutableLiveData<Boolean>()
    val errorCraftTypeValid: LiveData<Boolean>
        get() = _errorNameValid

    private val _errorDescriptionValid = MutableLiveData<Boolean>()
    val errorDescriptionValid: LiveData<Boolean>
        get() = _errorNameValid


    fun addNewItem(
        inputName: String?,
        inputCraftType: String?,
        inputDescription: String?
    ) {
        val name = parseInput(inputName)
        val craftType = parseInput(inputCraftType)
        val description = parseInput(inputDescription)
        val validInput = validateInput(name, craftType, description)
        if (validInput) {
            val item = CraftItem(name, craftType, description)
            addNewItemUseCase.addNewItem(item)
        }

    }

    fun getItem(id: String): CraftItem {
        return getItemUseCase.getItem(id)
    }

    fun editItem(
        craftItem: CraftItem,
        inputName: String?,
        inputCraftType: String?,
        inputDescription: String?
    ) {
        val name = parseInput(inputName)
        val craftType = parseInput(inputCraftType)
        val description = parseInput(inputDescription)
        val validInput = validateInput(name, craftType, description)
        if (validInput) {
            val newItem = craftItem.copy(name, craftType, description)
            editItemUseCase.editItem(newItem)
        }

    }

    private fun parseInput(input: String?): String {
        return input?.trim() ?: ""
    }

    private fun validateInput(
        name: String,
        craftType: String,
        description: String
    ): Boolean {
        var result = true
        result = when {
            name.isBlank() -> {
                TODO("error")
                false
            }
            craftType.isBlank() -> {
                TODO("error")
                false
            }
            description.isBlank() -> {
                TODO("error")
                false
            }
            else -> true
        }
        return result
    }
}