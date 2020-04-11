package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.ProductDetailsState
import kotlinx.coroutines.flow.Flow

typealias Id = Int

interface ProductDetailsStateRepository {
    fun productsDetailsState(): Flow<ProductDetailsState>
    fun onProductDetailsIntent(id: Int)
}