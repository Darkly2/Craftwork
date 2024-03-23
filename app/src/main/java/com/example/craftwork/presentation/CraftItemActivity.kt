package com.example.craftwork.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.craftwork.R

class CraftItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_craft_item)

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
        private const val MODE_EDIT = "mode_add"
    }
}