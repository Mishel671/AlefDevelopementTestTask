package com.example.alefdevelopementtesttask.data.mapper

import com.example.alefdevelopementtesttask.data.database.ImageItemDbModel
import com.example.alefdevelopementtesttask.data.network.model.ImageItemDto
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.google.gson.JsonArray

class ImageMapper {


    fun mapDbModelToEntity(dbModel: ImageItemDbModel) = ImageItem(
        imageUrl = dbModel.imageUrl
    )

    fun mapJsonArrayToDtoList(jsonArray: JsonArray): List<ImageItemDto> {
        val imageItemList = ArrayList<ImageItemDto>()
        for (jsonItem in jsonArray) {
            imageItemList.add(ImageItemDto(imageUrl = jsonItem.asString))
        }
        return imageItemList
    }

    fun mapDtoToDbModel(dto: ImageItemDto) = ImageItemDbModel(
        imageUrl = dto.imageUrl
    )

}