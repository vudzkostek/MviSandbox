package com.arturkosta.mvisandbox.di

import android.content.Context
import android.content.SharedPreferences
import com.arturkosta.mvisandbox.BuildConfig
import com.arturkosta.mvisandbox.MainActivity
import com.arturkosta.mvisandbox.di.MainActivityComponent.Bindings
import com.arturkosta.mvisandbox.di.MainActivityComponent.Providers
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModule::class,
        Providers::class,
        Bindings::class
    ]
)
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    @Module
    object Providers {
        @Provides
        fun provideSharedPrefs(context: Context): SharedPreferences {
            return context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        }
    }

    @Module
    abstract class Bindings
}

interface MainActivityComponentProvider {
    val mainActivityComponent: MainActivityComponent
}

internal val MainActivity.mainActivityComponent: MainActivityComponent
    get() = (applicationContext as MainActivityComponentProvider).mainActivityComponent