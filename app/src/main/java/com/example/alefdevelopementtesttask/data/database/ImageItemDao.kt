package com.example.alefdevelopementtesttask.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageItemDao {
    @Query("SELECT * FROM photo_list ORDER BY imageUrl DESC")
    fun getImageList(): LiveData<List<ImageItemDbModel>>

    @Query("SELECT * FROM photo_list WHERE  imageUrl LIKE  :url ")
    fun getImageItem(url: String): LiveData<ImageItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageList(imageList: List<ImageItemDbModel>)
}
