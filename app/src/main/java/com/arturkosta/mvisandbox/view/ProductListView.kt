package com.arturkosta.mvisandbox.view

import android.view.View
import com.arturkosta.mvisandbox.domain.ProductListState
import kotlinx.coroutines.flow.Flow

interface ProductListView {
    fun render(productListState: ProductListState)
    fun loadProductsIntent(): Flow<View>
}