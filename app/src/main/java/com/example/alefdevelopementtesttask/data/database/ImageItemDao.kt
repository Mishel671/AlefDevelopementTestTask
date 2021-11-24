package com.example.alefdevelopementtesttask.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageItemDao {
    @Query("SELECT * FROM photo_list ORDER BY id DESC")
    fun getImageList(): LiveData<List<ImageItemDbModel>>

    @Query("SELECT * FROM photo_list WHERE id == :id LIMIT 1")
    fun getImageItem(id: Int): LiveData<ImageItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(priceList: List<ImageItemDbModel>)
}