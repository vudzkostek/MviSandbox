package com.arturkosta.mvisandbox.view

import com.arturkosta.mvisandbox.state.AppState
import kotlinx.coroutines.flow.Flow

interface MainScreen {
    fun render(appState: AppState)
    fun goBackIntent(): Flow<Boolean>
}