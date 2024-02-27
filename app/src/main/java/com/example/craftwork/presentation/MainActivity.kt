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


        val craftItemAdapter = CraftItemAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.craftItemList.observe(this) {
            craftItemAdapter.submitList(it)
        }

        val recyclerView = binding.root
        recyclerView.adapter = craftItemAdapter


    }


    companion object {
        const val TAG = "MainActivity"
    }
}