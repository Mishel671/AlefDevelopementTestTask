package com.example.alefdevelopementtesttask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_list")
data class ImageItemDbModel(
    @PrimaryKey
    val imageUrl: String
)