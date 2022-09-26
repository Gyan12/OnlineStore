package com.example.onlinestore.UseCases.getProductDetailsUseCase

import com.example.onlinestore.Common.Resource
import com.example.onlinestore.Data.Remote.dto.toproductDetail
import com.example.onlinestore.Model.Repository.productRepository
import com.example.onlinestore.Model.productDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getProductDetailsUseCase @Inject constructor(
    private val repository: productRepository
) {
    operator fun invoke() : Flow<Resource<List<productDetail>>> = flow {
        try {
            emit(Resource.Loading())
            val productDetails = repository.getProductDetails().map { it.toproductDetail() }
            emit(Resource.Success(productDetails ?: emptyList()))
        }
        catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch (e:IOException) {
            emit(Resource.Error("Couldn't Reach Server. Try Again"))
        }


    }
}