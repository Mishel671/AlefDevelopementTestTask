package com.example.alefdevelopementtesttask.data.network

import com.example.alefdevelopementtesttask.data.network.model.ImageItemJsonContainerDto
import com.example.alefdevelopementtesttask.data.network.model.ImageItemListDto
import com.example.alefdevelopementtesttask.domain.ImageItem
import retrofit2.http.GET

interface ApiService {

    @GET("list.php")
    suspend fun getPhotoList(
    ): ImageItemJsonContainerDto

}