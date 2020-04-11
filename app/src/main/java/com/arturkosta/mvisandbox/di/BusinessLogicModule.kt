package com.arturkosta.mvisandbox.di

import com.arturkosta.mvisandbox.state.BusinessLogic
import com.arturkosta.mvisandbox.state.BusinessLogicImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BusinessLogicModule {

    @Binds
    abstract fun bindBusinessLogic(businessLogic: BusinessLogicImpl): BusinessLogic
}