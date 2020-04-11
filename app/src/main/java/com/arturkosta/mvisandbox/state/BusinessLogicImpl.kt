package com.arturkosta.mvisandbox.state

import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BusinessLogicImpl @Inject constructor() : BusinessLogic {

    // TODO implement some history of app stack
    private val stack = mutableListOf<AppState>()
    private val appState = ConflatedBroadcastChannel<AppState>(AppState.ProductList)

    override fun observeAppState(): Flow<AppState> = appState.asFlow()

    override fun onPartialState(partialState: AppPartialState) {
        appState.offer(appState.value.reduce(partialState))
    }

    private fun AppState.reduce(partialState: AppPartialState): AppState =
        when (this) {
            AppState.ProductList -> handlePartialStateForProductList(partialState)
            AppState.Exit -> this
            else -> handlePartialStateCommonly(partialState)
        }

    private fun handlePartialStateForProductList(partialState: AppPartialState): AppState =
        when (partialState) {
            AppPartialState.Back -> AppState.Exit
            is AppPartialState.ProductId -> AppState.ProductDetails(partialState.id)
        }

    private fun handlePartialStateCommonly(partialState: AppPartialState): AppState =
        when (partialState) {
            AppPartialState.Back -> AppState.ProductList
            is AppPartialState.ProductId -> AppState.ProductDetails(partialState.id)
        }
}