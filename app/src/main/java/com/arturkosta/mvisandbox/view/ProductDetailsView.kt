package com.arturkosta.mvisandbox.view

import com.arturkosta.mvisandbox.state.AppState

interface ProductDetailsView {
    fun render(appState: AppState.ProductDetails)
}