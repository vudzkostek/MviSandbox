package com.arturkosta.mvisandbox

import android.app.Application
import com.arturkosta.mvisandbox.di.*

class MviApplication : Application(), AppComponentProvider, MainActivityComponentProvider {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override val mainActivityComponent: MainActivityComponent by lazy {
        appComponent.mainActivityComponent().create()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}