package com.example.craftwork.domain.craftItem

import com.example.craftwork.domain.Image.Image

data class CraftItem (
    val id: String,
    val name: String,
    val craftType: String,
    val description: String,
    val mainImage: Image,
    val images: List<Image>
)