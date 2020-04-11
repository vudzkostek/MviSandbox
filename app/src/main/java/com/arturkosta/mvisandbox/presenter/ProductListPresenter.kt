package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.navigator.Navigator
import com.arturkosta.mvisandbox.repository.ProductListStateRepository
import com.arturkosta.mvisandbox.view.ProductListView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductListPresenter @Inject constructor(
    private val productListStateRepository: ProductListStateRepository,
    private val navigator: Navigator
) : Presenter() {

    fun bind(productListView: ProductListView) {
        productListView.loadProductsIntent()
            .onEach { productListStateRepository.onProductListIntent() }
            .launchIn(presenterScope)
        productListView.openProductDetailsIntent()
            .onEach { navigator.openProductDetails(it) }
            .launchIn(presenterScope)
        productListView.removeProductIntent()
            .onEach { productListStateRepository.onProductRemoveIntent(it) }
            .launchIn(presenterScope)
        productListStateRepository.productsListState()
            .onEach { productListView.render(it) }
            .launchIn(presenterScope)
    }
}