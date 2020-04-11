package com.arturkosta.mvisandbox.repository

import com.arturkosta.mvisandbox.domain.ProductDetailsState
import com.arturkosta.mvisandbox.domain.ProductListState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsStateRepository @Inject constructor(
    private val productListRepository: ProductListRepository,
    private val productDetailsRepository: ProductDetailsRepository
) : ProductListStateRepository, ProductDetailsStateRepository {

    private val productsChannel = ConflatedBroadcastChannel<ProductListState>()
    private val productDetailsChannel = ConflatedBroadcastChannel<ProductDetailsState>()

    override fun productsListState(): Flow<ProductListState> = productsChannel.asFlow()

    override fun onProductListIntent() {
        productsChannel.offer(ProductListState.LoadingState)

        GlobalScope.async {
            try {
                productsChannel.offer(ProductListState.DataState(productListRepository.fetchProducts()))
            } catch (e: RepositoryException) {
                productsChannel.offer(ProductListState.ErrorState(e.msg))
            }
        }
    }

    override fun onProductRemoveIntent(id: Int) {
        productsChannel.offer(ProductListState.LoadingState)

        GlobalScope.async {
            try {
                productListRepository.removeItem(id)
                productsChannel.offer(ProductListState.DataState(productListRepository.fetchProducts()))
            } catch (e: RepositoryException) {
                productsChannel.offer(ProductListState.ErrorState(e.msg))
            }
        }
    }

    override fun productsDetailsState(): Flow<ProductDetailsState> = productDetailsChannel.asFlow()

    override fun onProductDetailsIntent(id: Int) {
        productDetailsChannel.offer(ProductDetailsState.LoadingState)
        GlobalScope.async {
            try {
                productDetailsChannel.offer(
                    ProductDetailsState.DataState(
                        productDetailsRepository.getDetails(id)
                    )
                )
            } catch (e: RepositoryException) {
                productDetailsChannel.offer(ProductDetailsState.ErrorState(e.msg))
            }
        }
    }
}