package com.example.alefdevelopementtesttask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_list")
data class ImageItemDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUrl: String
)