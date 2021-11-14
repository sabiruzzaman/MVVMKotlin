package com.longitude23.mvvmkotlin.mainActivity.model

import com.longitude23.mvvmkotlin.mainActivity.model.dataModel.ImageDataModel
import com.longitude23.mvvmkotlin.network.ApiClient
import com.longitude23.mvvmkotlin.network.ApiInterface
import com.longitude23.mvvmkotlin.network.RequestCompleteListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityModel {

    companion object {
        private val apiInterface: ApiInterface = ApiClient().getClient.create(ApiInterface::class.java)

        fun getImageList(callback: RequestCompleteListener<MutableList<ImageDataModel>>) {
            val call: Call<MutableList<ImageDataModel>> = apiInterface.getImageArray()
            call.enqueue(object : Callback<MutableList<ImageDataModel>> {
                override fun onResponse(
                    call: Call<MutableList<ImageDataModel>>,
                    response: Response<MutableList<ImageDataModel>>
                ) {
                    if (response.code() == 200) {
                        response.body()?.let { callback.onSuccess(it.toMutableList()) }
                    } else {
                        callback.onFailed(response.message())
                    }
                }

                override fun onFailure(call: Call<MutableList<ImageDataModel>>, t: Throwable) {
                    callback.onFailed(t.message.toString())
                }

            })
        }
    }


}