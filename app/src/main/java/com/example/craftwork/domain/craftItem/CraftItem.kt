package com.example.craftwork.domain.craftItem

data class CraftItem(
    val name: String,
    val craftType: String,
    //val description: String,
    // val mainImage: Image,
    //val images: List<Image>,
    var id: String = UNDEFINED_ID, // when plugin Room and Firebase change to val
) {
    companion object {
        const val UNDEFINED_ID = "-1"
    }
}