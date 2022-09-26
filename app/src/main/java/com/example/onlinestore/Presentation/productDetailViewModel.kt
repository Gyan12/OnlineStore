package com.example.onlinestore.Presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.Common.Resource
import com.example.onlinestore.UseCases.getProductDetailsUseCase.getProductDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class productDetailViewModel @Inject constructor(
    private val GetProductDetailUseCase: getProductDetailsUseCase
) : ViewModel() {
    private val _state : MutableLiveData<productDetailState> = MutableLiveData()

    init {
        setState()
    }

    public fun getState() : MutableLiveData<productDetailState> {
        return _state
    }

    private fun setState(){
        GetProductDetailUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value= productDetailState(data = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = productDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = productDetailState(error = result.message ?: "An unexpected Error Occured")
                }
            }
        }.launchIn(viewModelScope)
    }



}