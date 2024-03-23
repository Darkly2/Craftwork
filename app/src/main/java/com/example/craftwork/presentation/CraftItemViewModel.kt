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

    private val _craftItemLD = MutableLiveData<CraftItem>()
    val craftItemLD: LiveData<CraftItem>
        get() = _craftItemLD

    private val _errorNameValid = MutableLiveData<Boolean>()
    val errorNameValid: LiveData<Boolean>
        get() = _errorNameValid

    private val _errorCraftTypeValid = MutableLiveData<Boolean>()
    val errorCraftTypeValid: LiveData<Boolean>
        get() = _errorNameValid

    private val _errorDescriptionValid = MutableLiveData<Boolean>()
    val errorDescriptionValid: LiveData<Boolean>
        get() = _errorNameValid

    private val _shouldCloseScreenLD = MutableLiveData<Unit>()
    val shouldCloseScreenLD: LiveData<Unit>
        get() = _shouldCloseScreenLD



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
            finishWork()
        }

    }

    fun getItem(id: String){
        val item = getItemUseCase.getItem(id)
        _craftItemLD.value = item
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
            _craftItemLD.value?.let{
                val item = it.copy(
                    name = name,
                    craftType = craftType,
                    description = description
                )
                editItemUseCase.editItem(item)
                finishWork()
            }
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
                _errorNameValid.value = true
                false
            }
            craftType.isBlank() -> {
                _errorCraftTypeValid.value = true
                false
            }
            description.isBlank() -> {
                _errorDescriptionValid.value = true
                false
            }
            else -> true
        }
        return result
    }

    private fun resetErrorName() {
        _errorNameValid.value = false
    }
    private fun resetErrorCraftType() {
        _errorCraftTypeValid.value = false
    }
    private fun resetErrorDescription() {
        _errorDescriptionValid.value = false
    }

    private fun finishWork() {
        _shouldCloseScreenLD.value = Unit
    }
}