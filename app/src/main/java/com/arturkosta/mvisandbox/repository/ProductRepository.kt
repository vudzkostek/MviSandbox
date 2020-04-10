package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.model.ProductListState
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun fetchProducts(): Flow<ProductListState>
}