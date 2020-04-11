package com.arturkosta.mvisandbox.view

import com.arturkosta.mvisandbox.domain.ProductDetailsState

interface ProductDetailsView {
    fun render(productDetailsState: ProductDetailsState)
}