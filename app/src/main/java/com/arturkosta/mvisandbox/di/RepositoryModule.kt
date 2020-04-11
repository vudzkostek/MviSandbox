package com.arturkosta.mvisandbox.di

import com.arturkosta.mvisandbox.repository.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductListRepository(repository: ProductsRepository): ProductListRepository

    @Binds
    abstract fun bindProductDetailsRepository(repository: ProductsRepository): ProductDetailsRepository

    @Binds
    abstract fun bindProductListStateRepository(repository: ProductsStateRepository): ProductListStateRepository

    @Binds
    abstract fun bindProductDetailsStateRepository(repository: ProductsStateRepository): ProductDetailsStateRepository
}