package com.arturkosta.mvisandbox.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class Presenter {
    protected val presenterScope = CoroutineScope(Dispatchers.Main)

}