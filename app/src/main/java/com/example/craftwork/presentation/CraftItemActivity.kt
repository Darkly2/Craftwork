package com.example.craftwork.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.craftwork.R
import com.example.craftwork.databinding.CraftItemBinding

class CraftItemActivity : AppCompatActivity() {

    private lateinit var binding: CraftItemBinding
    private lateinit var viewModel: CraftItemViewModel

    private var screenMode = ""
    private var craftItemId = "-1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CraftItemBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        parseIntent()
        viewModel = ViewModelProvider(this)[CraftItemViewModel::class.java]
        when(screenMode) {
            MODE_ADD -> launchAddMode()
            MODE_EDIT -> launchEditMode()
        }
    }

    private fun launchAddMode() {
        val name = binding.textViewCraftItemName.text.toString()
        val craftType = binding.textViewCraftItemType.text.toString()
        val description = binding.textViewCraftItemType.text.toString()
        viewModel.addNewItem(name, craftType, description)
        viewModel.resetErrorName()
        viewModel.resetErrorCraftType()
        viewModel.resetErrorDescription()
    }

    private fun launchEditMode() {
        viewModel.craftItemLD.observe(this, { TODO("SET TEXT TO FIELDS")  })
        val name = binding.textViewCraftItemName.text.toString()
        val craftType = binding.textViewCraftItemType.text.toString()
        val description = binding.textViewCraftItemType.text.toString()
    }

    private fun parseIntent(){
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException("Parse screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_ADD && mode != MODE_EDIT) {
            throw RuntimeException("Unknown mode: $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            craftItemId = intent.getStringExtra(EXTRA_ITEM_ID).toString()
            if (!intent.hasExtra(EXTRA_ITEM_ID)) {
                throw RuntimeException("Parse item ID is absent")
            }
        }
    }

    companion object {
        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, CraftItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, id: String): Intent {
            val intent = Intent(context, CraftItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_ITEM_ID, id)
            return intent
        }

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_ITEM_ID = "extra_item_id"
        private const val MODE_ADD = "mode_add"
        private const val MODE_EDIT = "mode_edit"
    }
}