package com.example.alefdevelopementtesttask.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.alefdevelopementtesttask.data.repository.ImageRepositoryImpl
import com.example.alefdevelopementtesttask.domain.GetImageItemListUseCase
import com.example.alefdevelopementtesttask.domain.GetImageItemUseCase
import com.example.alefdevelopementtesttask.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class ImageListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ImageRepositoryImpl(application)

    private val getImageItemListUseCase = GetImageItemListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val imageItemList = getImageItemListUseCase()

    fun loadData(){
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
    init {
        loadData()
    }
}