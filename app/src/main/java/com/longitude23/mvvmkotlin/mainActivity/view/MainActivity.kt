package com.longitude23.mvvmkotlin.mainActivity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmkotlin.databinding.ActivityMainBinding
import com.longitude23.mvvmkotlin.mainActivity.adapter.ImageAdapter
import com.longitude23.mvvmkotlin.mainActivity.viewModel.MainViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.longitude23.mvvmkotlin.mainActivity.model.dataModel.ImageDataModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //view binding
        setContentView(binding.root) //attach root view with activity

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) //initialize viewModel
        setLiveDataListeners()   //observe data changing
        viewModel.getImageList() //request for data whenever you need



        adapter = ImageAdapter(this)
        binding.imageGridViewId.layoutManager = GridLayoutManager(this, 2)
        binding.imageGridViewId.adapter = adapter

    }

    private fun setLiveDataListeners() {
        viewModel.imageModelListLiveData.observe(this, {

            adapter.addData(it)

            Log.i("checkData", "setLiveDataListeners: ${it.size}")
        })

        viewModel.imageFailureLiveData.observe(this, {
            Log.i("checkData", "setLiveDataListeners: $it")
        })

        viewModel.progressBarLiveData.observe(this, { isProgress ->
            if (isProgress) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }
}