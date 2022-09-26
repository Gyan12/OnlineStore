package com.example.onlinestore.Model.Repository

import com.example.onlinestore.Data.Remote.dto.productDetailDto
import com.example.onlinestore.Model.productDetail

interface productRepository {

    suspend fun getProductDetails() : List<productDetailDto>
}