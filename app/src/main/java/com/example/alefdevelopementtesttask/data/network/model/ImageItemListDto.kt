package com.example.alefdevelopementtesttask.data.network.model

import com.example.alefdevelopementtesttask.domain.ImageItem
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageItemListDto(
    @Expose
    val imageList: List<ImageItem>? = null
)