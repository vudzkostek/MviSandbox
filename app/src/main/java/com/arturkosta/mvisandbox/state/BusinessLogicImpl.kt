package com.arturkosta.mvisandbox.state

import com.arturkosta.mvisandbox.domain.ProductDetailsState
import com.arturkosta.mvisandbox.domain.ProductListState
import com.arturkosta.mvisandbox.repository.ProductDetailsStateRepository
import com.arturkosta.mvisandbox.repository.ProductListStateRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BusinessLogicImpl @Inject constructor(
    private val productListStateRepository: ProductListStateRepository,
    private val productDetailsStateRepository: ProductDetailsStateRepository
) : BusinessLogic {

    init {
        productDetailsStateRepository.productsDetailsState()
            .onEach {
                appState.offer(
                    when (it) {
                        ProductDetailsState.LoadingState -> AppState.ProductDetails.Loading
                        is ProductDetailsState.ErrorState -> AppState.ProductDetails.Error(it.errorMessage)
                        is ProductDetailsState.DataState -> AppState.ProductDetails.Data(it.data)
                    }
                )
            }
            .launchIn(GlobalScope)

        productListStateRepository.productsListState()
            .onEach {
                appState.offer(
                    when (it) {
                        ProductListState.LoadingState -> AppState.ProductList.Loading
                        is ProductListState.ErrorState -> AppState.ProductList.Error(it.errorMessage)
                        is ProductListState.DataState -> AppState.ProductList.Data(it.data)
                    }
                )
            }
            .launchIn(GlobalScope)
    }

    // TODO implement some history of app stack
    private val stack = mutableListOf<AppState>()
    private val appState = ConflatedBroadcastChannel<AppState>(AppState.ProductList.Initial)

    override fun observeAppState(): Flow<AppState> = appState.asFlow()

    override fun onPartialState(partialState: AppPartialState) {
        appState.offer(appState.value.reduce(partialState))
    }

    private fun AppState.reduce(partialState: AppPartialState): AppState =
        when (partialState) {
            is AppPartialState.ProductId -> {
                productDetailsStateRepository.onProductDetailsIntent(partialState.id)
                AppState.ProductDetails.Loading
            }
            is AppPartialState.RemoveProduct -> {
                productListStateRepository.onProductRemoveIntent(partialState.id)
                AppState.ProductList.Loading
            }
            AppPartialState.LoadList -> {
                productListStateRepository.onProductListIntent()
                AppState.ProductList.Loading
            }
            AppPartialState.Back -> handleBackIntent()
        }

    private fun AppState.handleBackIntent(): AppState =
        when (this) {
            is AppState.ProductList -> {
                AppState.Exit
            }
            is AppState.ProductDetails -> {
                productListStateRepository.onProductListIntent()
                AppState.ProductList.Loading
            }
            else -> this
        }
}