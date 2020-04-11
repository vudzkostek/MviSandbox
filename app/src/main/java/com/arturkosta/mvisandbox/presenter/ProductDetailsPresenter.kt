package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.repository.ProductDetailsStateRepository
import com.arturkosta.mvisandbox.state.AppState
import com.arturkosta.mvisandbox.state.BusinessLogic
import com.arturkosta.mvisandbox.widget.ProductsDetailsView
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductDetailsPresenter @Inject constructor(
    private val businessLogic: BusinessLogic
) : Presenter() {

    fun bind(productDetailsView: ProductsDetailsView) {
        businessLogic.observeAppState()
            .filterIsInstance<AppState.ProductDetails>()
            .onEach { productDetailsView.render(it) }
            .launchIn(presenterScope)
    }
}