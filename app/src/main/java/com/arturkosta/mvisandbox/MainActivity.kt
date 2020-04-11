package com.arturkosta.mvisandbox

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arturkosta.mvisandbox.databinding.ActivityMainBinding
import com.arturkosta.mvisandbox.di.mainActivityComponent
import com.arturkosta.mvisandbox.navigator.Navigator
import com.squareup.inject.inflation.InflationInjectFactory
import dagger.Provides
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Navigator {
    @Inject
    lateinit var injectViewFactory: InflationInjectFactory

    private lateinit var binding: ActivityMainBinding
    private var isInDetailsScreen = false

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

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun openProductDetails(id: Int) {
        binding.productListScreen.root.visibility = View.GONE
        binding.productDetailsScreen.root.visibility = View.VISIBLE
        isInDetailsScreen = true
    }

    override fun onBackPressed() {
        binding.productListScreen.root.visibility = View.VISIBLE
        binding.productDetailsScreen.root.visibility = View.GONE
        isInDetailsScreen = false
    }
}
