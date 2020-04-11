package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.repository.ProductDetailsStateRepository
import com.arturkosta.mvisandbox.repository.ProductListStateRepository
import com.arturkosta.mvisandbox.state.AppPartialState
import com.arturkosta.mvisandbox.state.BusinessLogic
import com.arturkosta.mvisandbox.view.ProductListView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductListPresenter @Inject constructor(
    private val productListStateRepository: ProductListStateRepository,
    private val productDetailsStateRepository: ProductDetailsStateRepository,
    private val  businessLogic: BusinessLogic
) : Presenter() {

    fun bind(productListView: ProductListView) {
        productListView.loadProductsIntent()
            .onEach { productListStateRepository.onProductListIntent() }
            .launchIn(presenterScope)
        productListView.openProductDetailsIntent()
            .onEach { productDetailsStateRepository.onProductDetailsIntent(it) }
            .onEach { businessLogic.onPartialState(AppPartialState.ProductId(it)) }
            .launchIn(presenterScope)
        productListView.removeProductIntent()
            .onEach { productListStateRepository.onProductRemoveIntent(it) }
            .launchIn(presenterScope)
        productListStateRepository.productsListState()
            .onEach { productListView.render(it) }
            .launchIn(presenterScope)
    }
}