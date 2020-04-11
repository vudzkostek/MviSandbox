package com.arturkosta.mvisandbox.repository

class NoSuchProductException(msg: String, e: Exception? = null) : RepositoryException(msg, e)