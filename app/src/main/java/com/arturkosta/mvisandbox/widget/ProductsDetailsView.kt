package com.arturkosta.mvisandbox.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.arturkosta.mvisandbox.databinding.ProductDetailsLayoutBinding
import com.arturkosta.mvisandbox.domain.ProductDetailsState
import com.arturkosta.mvisandbox.presenter.ProductDetailsPresenter
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

    override fun render(productDetailsState: ProductDetailsState) {
        when (productDetailsState) {
            is ProductDetailsState.DataState -> renderDataState(productDetailsState)
            is ProductDetailsState.LoadingState -> renderLoadingState()
            is ProductDetailsState.ErrorState -> renderErrorState(productDetailsState)
        }
    }

    private fun renderDataState(dataState: ProductDetailsState.DataState) {
        binding.title.text = dataState.data.title
        binding.description.text = dataState.data.description
    }

    private fun renderLoadingState() {
        binding.title.text = "Loading..."
        binding.description.text = "Loading..."
    }

    private fun renderErrorState(errorState: ProductDetailsState.ErrorState) {
        binding.title.text = "Error: ${errorState.errorMessage}"
        binding.description.text = "Error: ${errorState.errorMessage}"
    }
}