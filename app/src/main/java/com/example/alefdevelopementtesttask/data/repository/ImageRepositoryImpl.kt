package com.example.alefdevelopementtesttask.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.alefdevelopementtesttask.data.database.AppDatabase
import com.example.alefdevelopementtesttask.data.mapper.ImageMapper
import com.example.alefdevelopementtesttask.data.network.ApiFactory
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.example.alefdevelopementtesttask.domain.ImageRepository

class ImageRepositoryImpl(
    private val application: Application
) : ImageRepository {

    private val mapper = ImageMapper()
    private val imageItemDao = AppDatabase.getInstance(application).imageItemDao()

    private val apiService = ApiFactory.apiService

    override fun getImageItemList(): LiveData<List<ImageItem>> {
        return Transformations.map(imageItemDao.getImageList()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getImageItem(url: String): LiveData<ImageItem> {
        return Transformations.map(imageItemDao.getImageItem(url)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {

        try {
            val jsonArray = apiService.getPhotoList()
            val imageItemList = mapper.mapJsonArrayToDtoList(jsonArray)
            val dbModelList = imageItemList.map { mapper.mapDtoToDbModel(it) }
            imageItemDao.insertImageList(dbModelList)
        } catch (e: Exception) {
        }


    }
}