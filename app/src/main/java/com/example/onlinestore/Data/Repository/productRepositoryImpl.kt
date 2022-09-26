package com.example.onlinestore.Data.Repository

import com.example.onlinestore.Data.Remote.dto.productDetailDto
import com.example.onlinestore.Data.fakeStorApi
import com.example.onlinestore.Model.Repository.productRepository
import com.example.onlinestore.Model.productDetail
import javax.inject.Inject

class productRepositoryImpl @Inject constructor(
    private val api: fakeStorApi
) : productRepository{
    override suspend fun getProductDetails(): List<productDetailDto> {
        return api.getproductDetails()
    }


}