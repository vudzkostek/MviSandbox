package com.arturkosta.mvisandbox.state

import com.arturkosta.mvisandbox.domain.Product

sealed class AppState {
    object Exit : AppState()

    sealed class ProductList : AppState() {
        object Initial : ProductList()
        data class Data(val products: List<Product>) : ProductList()
        object Loading : ProductList()
        data class Error(val errorMessage: String) : ProductList()
    }

    sealed class ProductDetails : AppState() {
        data class Data(val productDetails: com.arturkosta.mvisandbox.domain.ProductDetails) :
            ProductDetails()

        object Loading : ProductDetails()
        data class Error(val errorMessage: String) : ProductDetails()
    }
}