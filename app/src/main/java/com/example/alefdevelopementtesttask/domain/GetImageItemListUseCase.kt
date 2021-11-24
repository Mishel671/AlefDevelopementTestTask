package com.example.alefdevelopementtesttask.domain

class GetImageItemListUseCase(
    private val repository: ImageRepository
) {
    operator fun invoke() = repository.getImageItemList()
}