package com.example.onlinestore.Data.Remote.dto

import com.example.onlinestore.Model.productDetail

data class productDetailDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

fun productDetailDto.toproductDetail() : productDetail {
    return productDetail(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating.rate,
        title = title
    )
}