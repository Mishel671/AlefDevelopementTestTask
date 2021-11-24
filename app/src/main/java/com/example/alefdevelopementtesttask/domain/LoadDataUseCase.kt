package com.example.alefdevelopementtesttask.domain

class LoadDataUseCase(
    private val repository: ImageRepository
) {

    suspend operator fun invoke() = repository.loadData()
}