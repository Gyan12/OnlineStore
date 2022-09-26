package com.example.onlinestore.DI

import com.example.onlinestore.Data.Repository.productRepositoryImpl
import com.example.onlinestore.Data.fakeStorApi
import com.example.onlinestore.Model.Repository.productRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun getProductApi() : fakeStorApi {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(fakeStorApi :: class.java)
    }

    @Provides
    @Singleton
    fun getProductRepository(api: fakeStorApi) : productRepository {
        return productRepositoryImpl(api)
    }
}