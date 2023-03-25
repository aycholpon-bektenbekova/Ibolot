package com.example.ibolot

import android.app.Application
import com.example.ibolot.domain.repository.Repository

class App : Application() {
    val repository: Repository by lazy {
        Repository()
    }
}