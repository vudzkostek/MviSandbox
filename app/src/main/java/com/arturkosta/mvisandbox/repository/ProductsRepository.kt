package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.Product
import com.arturkosta.mvisandbox.domain.ProductDetails
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor() : ProductListRepository, ProductDetailsRepository {

    private val products = mutableListOf(
        product(1),
        product(2),
        product(3),
        product(4),
        product(5),
        product(6),
        product(7),
        product(8),
        product(9),
        product(10),
        product(101),
        product(11),
        product(111),
        product(112),
        product(12),
        product(123),
        product(13)
    )

    private val productsDetails = mutableListOf(
        productDetails(1),
        productDetails(2),
        productDetails(3),
        productDetails(4),
        productDetails(5),
        productDetails(6),
        productDetails(7),
        productDetails(8),
        productDetails(9),
        productDetails(10)
    )

    @Throws(NoSuchProductException::class)
    override suspend fun getDetails(id: Int): ProductDetails {
        delay(5000)
        return productsDetails.firstOrNull { it.id == id }
            ?: throw NoSuchProductException("Product id=$id not found.")
    }

    @Throws(RepositoryException::class)
    override suspend fun fetchProducts(): List<Product> {
        delay(5000)
        return products
    }

    @Throws(RepositoryException::class)
    override suspend fun removeItem(id: Int): Boolean {
        delay(2000)
        products.removeIf { it.id == id }
        return true
    }

    private fun product(id: Int) = Product(id = id, title = "Title $id", price = "$id,$id$")
    private fun productDetails(id: Int) =
        ProductDetails(id = id, title = "Title $id", description = "Description $id")
}
