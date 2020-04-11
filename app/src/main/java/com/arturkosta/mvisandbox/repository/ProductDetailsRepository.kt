package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.ProductDetails

interface ProductDetailsRepository {

    @Throws(NoSuchProductException::class)
    suspend fun getDetails(id: Int): ProductDetails
}