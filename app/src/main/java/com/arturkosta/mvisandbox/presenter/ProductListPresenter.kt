package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.repository.ProductRepository
import com.arturkosta.mvisandbox.view.ProductListView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProductListPresenter(
    private val productListView: ProductListView,
    private val productRepository: ProductRepository
) : Presenter() {

    fun onViewCreated() {
        productRepository.fetchProducts()
            .onEach { productListView.render(it) }
            .launchIn(presenterScope)
    }
}