package com.example.alefdevelopementtesttask.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.alefdevelopementtesttask.data.database.AppDatabase
import com.example.alefdevelopementtesttask.data.database.ImageItemDao
import com.example.alefdevelopementtesttask.data.mapper.ImageMapper
import com.example.alefdevelopementtesttask.data.network.ApiFactory
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.example.alefdevelopementtesttask.domain.ImageRepository
import kotlinx.coroutines.delay

class ImageRepositoryImpl(
    private val application: Application
): ImageRepository{

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

    override fun getImageItem(id: Int): LiveData<ImageItem> {
        return Transformations.map(imageItemDao.getImageItem(id)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {

            try {
                val jsonContainer = apiService.getPhotoList()
                val imageItemList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = imageItemList.map { mapper.mapEntityToDbModel(it) }
                imageItemDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }

    }
}