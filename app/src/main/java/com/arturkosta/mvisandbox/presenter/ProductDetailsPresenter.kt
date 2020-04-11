package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.repository.ProductDetailsStateRepository
import com.arturkosta.mvisandbox.widget.ProductsDetailsView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductDetailsPresenter @Inject constructor(
    private val productDetailsStateRepository: ProductDetailsStateRepository
) : Presenter() {

    fun bind(productDetailsView: ProductsDetailsView) {
        productDetailsStateRepository.productsDetailsState()
            .onEach { productDetailsView.render(it) }
            .launchIn(presenterScope)
    }
}