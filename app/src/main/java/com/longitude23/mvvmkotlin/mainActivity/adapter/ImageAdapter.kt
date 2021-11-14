package com.longitude23.mvvmkotlin.mainActivity.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.databinding.ItemImageBinding
import com.longitude23.mvvmkotlin.mainActivity.model.dataModel.ImageDataModel

class ImageAdapter(private val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemImageBinding.bind(itemView)
    }

    private var imageList: MutableList<ImageDataModel> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(images: MutableList<ImageDataModel>) {
        imageList.addAll(images)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        imageList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        val image = imageList[position]

        with(holder.binding) {
            nameId.text = image.getAuthor()
            Glide.with(context).load(image.getDownloadUrl()).into(imageViewId)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}