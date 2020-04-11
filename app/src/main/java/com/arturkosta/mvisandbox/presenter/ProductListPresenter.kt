package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.state.AppPartialState
import com.arturkosta.mvisandbox.state.AppState
import com.arturkosta.mvisandbox.state.BusinessLogic
import com.arturkosta.mvisandbox.view.ProductListView
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductListPresenter @Inject constructor(
    private val businessLogic: BusinessLogic
) : Presenter() {

    fun bind(productListView: ProductListView) {
        productListView.loadProductsIntent()
            .onEach { businessLogic.onPartialState(AppPartialState.LoadList) }
            .launchIn(presenterScope)
        productListView.openProductDetailsIntent()
            .onEach { businessLogic.onPartialState(AppPartialState.ProductId(it)) }
            .launchIn(presenterScope)
        productListView.removeProductIntent()
            .onEach { businessLogic.onPartialState(AppPartialState.RemoveProduct(it)) }
            .launchIn(presenterScope)
        businessLogic.observeAppState()
            .filterIsInstance<AppState.ProductList>()
            .onEach { productListView.render(it) }
            .launchIn(presenterScope)
    }
}