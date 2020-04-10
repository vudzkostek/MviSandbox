package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.repository.ProductRepository
import com.arturkosta.mvisandbox.view.ProductListView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductListPresenter @Inject constructor(
    private val productRepository: ProductRepository
) : Presenter() {

    private lateinit var productListView: ProductListView

    fun bind(productListView: ProductListView) {
        this.productListView = productListView
        productListView.loadProductsIntent()
            .onEach { onLoadClick() }
            .launchIn(presenterScope)
    }

    private fun onLoadClick() {
        productRepository.fetchProducts()
            .onEach { productListView.render(it) }
            .launchIn(presenterScope)
    }
}