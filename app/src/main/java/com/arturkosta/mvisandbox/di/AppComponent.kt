package com.arturkosta.mvisandbox.di

import android.app.Application
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.arturkosta.mvisandbox.MviApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(application: MviApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
}

interface AppComponentProvider {
    val appComponent: AppComponent
}

val Context.appComponent: AppComponent
    get() = (applicationContext as AppComponentProvider).appComponent

val Fragment.appComponent: AppComponent
    get() = requireContext().appComponent

val View.appComponent: AppComponent
    get() = context.appComponent
