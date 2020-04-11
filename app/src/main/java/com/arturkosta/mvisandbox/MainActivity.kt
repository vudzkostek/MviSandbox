package com.arturkosta.mvisandbox

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arturkosta.mvisandbox.databinding.ActivityMainBinding
import com.arturkosta.mvisandbox.di.mainActivityComponent
import com.arturkosta.mvisandbox.presenter.MainActivityPresenter
import com.arturkosta.mvisandbox.state.AppState
import com.arturkosta.mvisandbox.view.MainScreen
import com.squareup.inject.inflation.InflationInjectFactory
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var injectViewFactory: InflationInjectFactory
    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    private lateinit var binding: ActivityMainBinding

    private val backPressChannel = BroadcastChannel<Boolean>(BUFFERED)

    override fun onCreateView(name: String, ctx: Context, attrs: AttributeSet): View? {
        return injectViewFactory.onCreateView(name, ctx, attrs) ?: super.onCreateView(
            name,
            ctx,
            attrs
        )
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        ctx: Context,
        attrs: AttributeSet
    ): View? {
        return injectViewFactory.onCreateView(parent, name, ctx, attrs)
            ?: super.onCreateView(parent, name, ctx, attrs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent.inject(this)
        mainActivityPresenter.bind(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        backPressChannel.offer(true)
    }

    override fun goBackIntent(): Flow<Boolean> = backPressChannel.asFlow()

    override fun render(appState: AppState) {
        when (appState) {
            AppState.Exit -> super.onBackPressed()
            AppState.ProductList -> openProductList()
            is AppState.ProductDetails -> openProductDetails()
        }
    }

    private fun openProductDetails() {
        binding.productListScreen.root.visibility = View.GONE
        binding.productDetailsScreen.root.visibility = View.VISIBLE
    }

    private fun openProductList() {
        binding.productListScreen.root.visibility = View.VISIBLE
        binding.productDetailsScreen.root.visibility = View.GONE
    }
}
