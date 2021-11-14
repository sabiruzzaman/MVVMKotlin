package com.longitude23.mvvmkotlin.network

import com.longitude23.mvvmkotlin.mainActivity.model.dataModel.ImageDataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/list")
    fun getImageArray(): Call<MutableList<ImageDataModel>>
}