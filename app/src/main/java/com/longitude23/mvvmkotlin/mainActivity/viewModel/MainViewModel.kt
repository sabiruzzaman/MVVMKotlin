package com.longitude23.mvvmkotlin.mainActivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.longitude23.mvvmkotlin.network.RequestCompleteListener
import com.longitude23.mvvmkotlin.mainActivity.model.MainActivityModel
import com.longitude23.mvvmkotlin.mainActivity.model.dataModel.ImageDataModel

class MainViewModel : ViewModel() {

    var imageModelListLiveData = MutableLiveData<MutableList<ImageDataModel>>()
    var imageFailureLiveData = MutableLiveData<String>()
    var progressBarLiveData = MutableLiveData<Boolean>()

    fun getImageList() {
        progressBarLiveData.postValue(true)
        MainActivityModel.getImageList(object : RequestCompleteListener<MutableList<ImageDataModel>> {
            override fun onSuccess(data: MutableList<ImageDataModel>) {
                imageModelListLiveData.postValue(data)
                progressBarLiveData.postValue(false)
            }

            override fun onFailed(message: String) {
                imageFailureLiveData.postValue(message)
                progressBarLiveData.postValue(false)
            }

        })
    }

}