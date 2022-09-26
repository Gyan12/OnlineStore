package com.example.onlinestore.Data

import com.example.onlinestore.Data.Remote.dto.productDetailDto
import com.example.onlinestore.Model.productDetail
import retrofit2.http.GET

interface fakeStorApi {

    @GET("products")
    suspend fun getproductDetails() : List<productDetailDto>

}