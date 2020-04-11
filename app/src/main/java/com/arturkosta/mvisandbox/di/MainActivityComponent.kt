package com.arturkosta.mvisandbox.di

import com.arturkosta.mvisandbox.MainActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModule::class
    ]
)
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}

interface MainActivityComponentProvider {
    val mainActivityComponent: MainActivityComponent
}

internal val MainActivity.mainActivityComponent: MainActivityComponent
    get() = (applicationContext as MainActivityComponentProvider).mainActivityComponent