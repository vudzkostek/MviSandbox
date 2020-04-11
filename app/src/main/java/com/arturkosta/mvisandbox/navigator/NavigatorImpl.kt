package com.arturkosta.mvisandbox.navigator

import android.util.Log
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {
    override fun openProductDetails(id: Int) {
        Log.i("TEST", "Open item $id")
    }
}