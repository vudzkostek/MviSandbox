package com.arturkosta.mvisandbox.view

import android.view.View
import com.arturkosta.mvisandbox.model.ProductListState
import kotlinx.coroutines.flow.Flow

interface ProductListView {
    fun render(productListState: ProductListState)
    fun loadProductsIntent(): Flow<View>
}