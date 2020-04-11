package com.arturkosta.mvisandbox.model

import com.arturkosta.mvisandbox.domain.Product

sealed class ProductState {
    object LoadingState : ProductState()
    data class DataState(val data: Product) : ProductState()
    data class ErrorState(val errorMessage: String) : ProductState()
}