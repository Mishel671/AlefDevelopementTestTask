package com.example.alefdevelopementtesttask.domain

class GetImageItemUseCase(
    private val repository: ImageRepository
) {

    operator fun invoke(url: String) = repository.getImageItem(url)
}