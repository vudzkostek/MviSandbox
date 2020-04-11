package com.arturkosta.mvisandbox.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.arturkosta.mvisandbox.databinding.ProductListLayoutBinding
import com.arturkosta.mvisandbox.presenter.ProductListPresenter
import com.arturkosta.mvisandbox.state.AppState
import com.arturkosta.mvisandbox.view.ProductListView
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.inflation.InflationInject
import kotlinx.coroutines.flow.Flow
import javax.inject.Provider

@SuppressLint("ViewConstructor") // Created by Inflation Inject.
class ProductsListView @InflationInject constructor(
    @Assisted context: Context,
    @Assisted attrs: AttributeSet?,
    presenterProvider: Provider<ProductListPresenter>
) : ConstraintLayout(context, attrs), ProductListView {

    private lateinit var binding: ProductListLayoutBinding
    private val presenter = presenterProvider.get()
    private val productListAdapter: ProductListAdapter
        get() = binding.productList.adapter as ProductListAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ProductListLayoutBinding.bind(this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        binding.productList.layoutManager = LinearLayoutManager(context)
        binding.productList.adapter = ProductListAdapter(context)

        presenter.bind(this)
    }

    override fun loadProductsIntent() = binding.load.clicks()
    override fun openProductDetailsIntent(): Flow<Int> = productListAdapter.itemClicks
    override fun removeProductIntent(): Flow<Int> = productListAdapter.itemLongClicks

    override fun render(appState: AppState.ProductList) {
        when (appState) {
            is AppState.ProductList.Data -> renderDataState(appState)
            is AppState.ProductList.Loading -> renderLoadingState()
            is AppState.ProductList.Error -> renderErrorState(appState)
        }
    }

    private fun renderDataState(dataState: AppState.ProductList.Data) {
        binding.state.text = "State: Idle"
        productListAdapter.setData(dataState.products)
    }

    private fun renderLoadingState() {
        binding.state.text = "State: Loading..."
        productListAdapter.clearData()
    }

    private fun renderErrorState(errorState: AppState.ProductList.Error) {
        binding.state.text = "State: Error"
        productListAdapter.clearData()
    }
}