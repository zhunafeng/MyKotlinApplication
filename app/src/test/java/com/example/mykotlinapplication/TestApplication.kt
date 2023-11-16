package com.example.mykotlinapplication

import android.app.Application
import timber.log.Timber
import com.anonyome.<insert-project>.ui.R

class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.AppTheme)
        Timber.plant(Timber.DebugTree())
    }
}