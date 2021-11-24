package com.example.alefdevelopementtesttask.domain

class GetImageItemUseCase(
    private val repository: ImageRepository
) {

    operator fun invoke(id: Int) = repository.getImageItem(id)
}