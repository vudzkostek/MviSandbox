package com.arturkosta.mvisandbox.state

sealed class AppState {
    object Exit : AppState()
    object ProductList : AppState()
    object LoadingProductList : AppState()
    object LoadingProductListError : AppState()
    data class ProductDetails(val id: Int) : AppState()
    object LoadingProductDetails : AppState()
    object LoadingProductDetailsError : AppState()
}