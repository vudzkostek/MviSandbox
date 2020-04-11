package com.arturkosta.mvisandbox.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.arturkosta.mvisandbox.databinding.ProductDetailsLayoutBinding
import com.arturkosta.mvisandbox.presenter.ProductDetailsPresenter
import com.arturkosta.mvisandbox.state.AppState
import com.arturkosta.mvisandbox.view.ProductDetailsView
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.inflation.InflationInject
import javax.inject.Provider

@SuppressLint("ViewConstructor") // Created by Inflation Inject.
class ProductsDetailsView @InflationInject constructor(
    @Assisted context: Context,
    @Assisted attrs: AttributeSet?,
    presenterProvider: Provider<ProductDetailsPresenter>
) : RelativeLayout(context, attrs), ProductDetailsView {

    private lateinit var binding: ProductDetailsLayoutBinding
    private val presenter = presenterProvider.get()

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ProductDetailsLayoutBinding.bind(this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        presenter.bind(this)
    }

    override fun render(appState: AppState.ProductDetails) {
        when (appState) {
            is AppState.ProductDetails.Data -> renderDataState(appState)
            is AppState.ProductDetails.Loading -> renderLoadingState()
            is AppState.ProductDetails.Error -> renderErrorState(appState)
        }
    }

    private fun renderDataState(dataState: AppState.ProductDetails.Data) {
        binding.title.text = dataState.productDetails.title
        binding.description.text = dataState.productDetails.description
    }

    private fun renderLoadingState() {
        binding.title.text = "Loading..."
        binding.description.text = "Loading..."
    }

    private fun renderErrorState(errorState: AppState.ProductDetails.Error) {
        binding.title.text = "Error: ${errorState.errorMessage}"
        binding.description.text = "Error: ${errorState.errorMessage}"
    }
}