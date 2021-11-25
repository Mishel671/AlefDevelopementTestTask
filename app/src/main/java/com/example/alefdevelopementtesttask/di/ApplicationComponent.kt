package com.example.alefdevelopementtesttask.di

import android.content.Context
import com.example.alefdevelopementtesttask.presentation.ImageListActivity
import com.example.alefdevelopementtesttask.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component()
interface ApplicationComponent {

    fun inject(activity: ImageListActivity)

    fun viewModelsFactory(): ViewModelFactory


    @Component.Factory
    interface  ApplicationComponentFactory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}