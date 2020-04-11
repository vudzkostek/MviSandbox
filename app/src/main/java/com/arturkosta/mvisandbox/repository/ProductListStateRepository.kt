package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.ProductListState
import kotlinx.coroutines.flow.Flow

interface ProductListStateRepository {
    fun productsListState(): Flow<ProductListState>
    fun onProductListIntent()
    fun onProductRemoveIntent(id: Int)
}