package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.Product

interface ProductListRepository {

    @Throws(RepositoryException::class)
    suspend fun fetchProducts(): List<Product>

    @Throws(RepositoryException::class)
    suspend fun removeItem(id: Int): Boolean
}