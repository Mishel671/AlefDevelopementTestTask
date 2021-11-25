package com.example.alefdevelopementtesttask.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.alefdevelopementtesttask.data.repository.ImageRepositoryImpl
import com.example.alefdevelopementtesttask.domain.GetImageItemUseCase

class DetailFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ImageRepositoryImpl(application)

    private val getImageItemUseCase = GetImageItemUseCase(repository)

    fun getDetailImage(url: String) = getImageItemUseCase(url)
}