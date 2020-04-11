package com.arturkosta.mvisandbox.state

import kotlinx.coroutines.flow.Flow

interface BusinessLogic {
    fun observeAppState(): Flow<AppState>
    fun onPartialState(partialState: AppPartialState)
}