package com.example.alefdevelopementtesttask

import android.app.Application
import com.example.alefdevelopementtesttask.di.DaggerApplicationComponent

class ImageApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}