package com.arturkosta.mvisandbox

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.arturkosta.mvisandbox.model.ProductListState
import com.arturkosta.mvisandbox.view.ProductListView
import com.arturkosta.mvisandbox.view.clicks

class MainActivity : AppCompatActivity(), ProductListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun loadProductsIntent() = findViewById<Button>(R.id.load).clicks()

    override fun render(productListState: ProductListState) {
        when (productListState) {
            is ProductListState.DataState -> renderDataState(productListState)
            is ProductListState.LoadingState -> renderLoadingState()
            is ProductListState.ErrorState -> renderErrorState(productListState)
        }
    }

    private fun renderDataState(dataState: ProductListState.DataState) {
        // Show products in list
    }

    private fun renderLoadingState() {
        // Show progress bar
    }

    private fun renderErrorState(errorState: ProductListState.ErrorState) {
        // Show error message
    }
}
