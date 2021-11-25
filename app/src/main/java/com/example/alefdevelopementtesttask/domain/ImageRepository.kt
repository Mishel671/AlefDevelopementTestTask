package com.example.alefdevelopementtesttask.domain

import androidx.lifecycle.LiveData

interface ImageRepository {

    fun getImageItemList(): LiveData<List<ImageItem>>

    fun getImageItem(url: String): LiveData<ImageItem>

    suspend fun loadData()
}