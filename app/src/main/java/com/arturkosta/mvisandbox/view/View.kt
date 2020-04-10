package com.arturkosta.mvisandbox.view

import android.view.View
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun View.clicks(): Flow<View> = callbackFlow {
    this@clicks.setOnClickListener {
        this.offer(it)
    }
    awaitClose { this@clicks.setOnClickListener(null) }
}