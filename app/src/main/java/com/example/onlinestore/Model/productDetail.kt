package com.example.onlinestore.Model

import com.example.onlinestore.Data.Remote.dto.Rating

data class productDetail (
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Double,
    val title: String
)
