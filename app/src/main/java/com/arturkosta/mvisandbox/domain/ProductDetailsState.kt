package com.arturkosta.mvisandbox.domain

sealed class ProductDetailsState {
    object LoadingState : ProductDetailsState()
    data class DataState(val data: ProductDetails) : ProductDetailsState()
    data class ErrorState(val errorMessage: String) : ProductDetailsState()
}