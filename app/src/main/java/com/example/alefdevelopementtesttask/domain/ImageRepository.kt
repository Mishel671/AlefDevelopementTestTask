package com.example.alefdevelopementtesttask.domain

import androidx.lifecycle.LiveData

interface ImageRepository {

    fun getImageItemList(): LiveData<List<ImageItem>>

    fun getImageItem(id: Int): LiveData<ImageItem>

    suspend fun loadData()
}