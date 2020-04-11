package com.arturkosta.mvisandbox.domain

data class Product(
    val id: Int,
    val title: String,
    var image: String? = null,
    val price: String
)