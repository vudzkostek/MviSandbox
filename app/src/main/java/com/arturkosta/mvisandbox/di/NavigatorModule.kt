package com.arturkosta.mvisandbox.di

import com.arturkosta.mvisandbox.navigator.Navigator
import com.arturkosta.mvisandbox.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigator(repository: NavigatorImpl): Navigator
}