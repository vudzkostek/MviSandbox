package com.arturkosta.mvisandbox

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arturkosta.mvisandbox.di.mainActivityComponent
import com.squareup.inject.inflation.InflationInjectFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var injectViewFactory: InflationInjectFactory

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
        setContentView(R.layout.activity_main)
    }
}
