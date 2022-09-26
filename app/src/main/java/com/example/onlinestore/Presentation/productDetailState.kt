package com.example.onlinestore.Presentation

import com.example.onlinestore.Model.productDetail

data class productDetailState(
    val isLoading : Boolean = false,
    val data : List<productDetail> = emptyList(),
    val error : String = ""
)
