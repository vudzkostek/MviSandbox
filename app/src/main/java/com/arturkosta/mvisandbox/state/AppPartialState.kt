package com.arturkosta.mvisandbox.state

sealed class AppPartialState {
    object Back : AppPartialState()
    data class ProductId(val id: Int) : AppPartialState()
}