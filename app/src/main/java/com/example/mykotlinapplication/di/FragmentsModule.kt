package com.example.mykotlinapplication.di

import com.example.mykotlinapplication.features.calculate.CalculateFragment
import com.example.mykotlinapplication.features.calculate.CalculateModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = [CalculateModule::class])
    abstract fun contributeFragmentAndroidInjector(): CalculateFragment
}