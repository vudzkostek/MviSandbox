package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.model.Product
import com.arturkosta.mvisandbox.model.ProductListState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor() : ProductRepository {
    override fun fetchProducts(): Flow<ProductListState> = flow {
        emit(ProductListState.LoadingState)
        delay(5000)
        emit(
            ProductListState.DataState(
                listOf(
                    product("title 1"),
                    product("title 2"),
                    product("title 1")
                )
            )
        )
    }

    private fun product(title: String) = Product(title = title)
}