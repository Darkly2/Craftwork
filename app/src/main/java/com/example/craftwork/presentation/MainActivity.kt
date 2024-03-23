package com.example.craftwork.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.craftwork.R
import com.example.craftwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val craftItemAdapter = CraftItemAdapter()
        viewModel.craftItemList.observe(this) {
            craftItemAdapter.submitList(it)
            Log.d(TAG, it.toString())
        }


        val recyclerView = binding.craftItemRWAdapter
        recyclerView.adapter = craftItemAdapter
    }


    companion object {
        const val TAG = "MainActivity"
    }
}