package com.example.alefdevelopementtesttask.data.mapper

import com.example.alefdevelopementtesttask.data.database.ImageItemDbModel
import com.example.alefdevelopementtesttask.data.network.model.ImageItemJsonContainerDto
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.google.gson.Gson

class ImageMapper {

    fun mapEntityToDbModel(imageItem: ImageItem) = ImageItemDbModel(
        imageUrl = imageItem.imageUrl
    )

    fun mapDbModelToEntity(dbModel: ImageItemDbModel) = ImageItem(
        id = dbModel.id,
        imageUrl = dbModel.imageUrl
    )


    fun mapJsonContainerToListCoinInfo(jsonContainer: ImageItemJsonContainerDto): List<ImageItem> {
        val result = mutableListOf<ImageItem>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    ImageItem::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }
}