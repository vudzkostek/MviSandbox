package com.arturkosta.mvisandbox.presenter

import com.arturkosta.mvisandbox.model.Presenter
import com.arturkosta.mvisandbox.state.AppPartialState
import com.arturkosta.mvisandbox.state.BusinessLogic
import com.arturkosta.mvisandbox.view.MainScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val businessLogic: BusinessLogic
) : Presenter() {

    fun bind(mainScreen: MainScreen) {
        businessLogic.observeAppState()
            .onEach { mainScreen.render(it) }
            .launchIn(presenterScope)
        mainScreen.goBackIntent()
            .onEach { businessLogic.onPartialState(AppPartialState.Back) }
            .launchIn(presenterScope)
    }
}