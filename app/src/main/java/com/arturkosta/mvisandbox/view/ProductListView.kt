package com.arturkosta.mvisandbox.view

import android.view.View
import com.arturkosta.mvisandbox.state.AppState
import kotlinx.coroutines.flow.Flow

interface ProductListView {
    fun render(appState: AppState.ProductList)
    fun loadProductsIntent(): Flow<View>
    fun openProductDetailsIntent(): Flow<Int>
    fun removeProductIntent(): Flow<Int>
}