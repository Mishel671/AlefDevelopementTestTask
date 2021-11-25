package com.example.alefdevelopementtesttask.data.network

import com.google.gson.JsonArray
import retrofit2.http.GET

interface ApiService {
    @GET("list.php")
    suspend fun getPhotoList(): JsonArray
}