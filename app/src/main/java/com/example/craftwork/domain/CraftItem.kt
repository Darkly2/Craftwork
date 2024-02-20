package com.example.craftwork.domain

data class CraftItem (
val id: String,
val name: String,
val craftType: String,
val description: String,
val mainImage: Image,
val images: List<Image>
)