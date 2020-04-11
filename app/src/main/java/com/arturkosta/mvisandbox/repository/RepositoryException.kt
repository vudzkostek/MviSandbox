package com.arturkosta.mvisandbox.repository

open class RepositoryException(val msg: String, e: Exception?) : RuntimeException(msg, e)