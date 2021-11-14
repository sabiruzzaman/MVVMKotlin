package com.longitude23.mvvmkotlin.network

interface RequestCompleteListener<T> {
    fun onSuccess(data: T)
    fun onFailed(message: String)
}