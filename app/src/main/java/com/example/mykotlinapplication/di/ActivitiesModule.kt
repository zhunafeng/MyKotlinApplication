package com.example.mykotlinapplication.di

import com.example.mykotlinapplication.features.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeAndroidInjector(): MainActivity
}