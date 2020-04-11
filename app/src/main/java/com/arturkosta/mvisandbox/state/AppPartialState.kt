package com.arturkosta.mvisandbox.state

sealed class AppPartialState {
    object Back : AppPartialState()
    object LoadList: AppPartialState()
    data class ProductId(val id: Int) : AppPartialState()
    data class RemoveProduct(val id: Int) : AppPartialState()
}