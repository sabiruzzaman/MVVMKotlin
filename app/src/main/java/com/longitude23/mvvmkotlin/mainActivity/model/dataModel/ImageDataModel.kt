package com.longitude23.mvvmkotlin.mainActivity.model.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageDataModel {
    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("author")
    @Expose
    private var author: String? = null

    @SerializedName("width")
    @Expose
    private var width: Int? = null

    @SerializedName("height")
    @Expose
    private var height: Int? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("download_url")
    @Expose
    private var downloadUrl: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getWidth(): Int? {
        return width
    }

    fun setWidth(width: Int?) {
        this.width = width
    }

    fun getHeight(): Int? {
        return height
    }

    fun setHeight(height: Int?) {
        this.height = height
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getDownloadUrl(): String? {
        return downloadUrl
    }

    fun setDownloadUrl(downloadUrl: String?) {
        this.downloadUrl = downloadUrl
    }
}