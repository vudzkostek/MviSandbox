package com.arturkosta.mvisandbox.di

import com.squareup.inject.inflation.InflationModule
import dagger.Module

@InflationModule
@Module(includes = [InflationInject_ViewModule::class])
object ViewModule
