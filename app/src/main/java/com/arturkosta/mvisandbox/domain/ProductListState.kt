package com.arturkosta.mvisandbox.domain

sealed class ProductListState {
    object LoadingState : ProductListState()
    data class DataState(val data: List<Product>) : ProductListState()
    data class ErrorState(val errorMessage: String) : ProductListState()
}