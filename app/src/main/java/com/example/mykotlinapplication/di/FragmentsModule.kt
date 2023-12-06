package com.example.mykotlinapplication.di

import com.example.mykotlinapplication.features.calculate.CalculateFragment
import com.example.mykotlinapplication.features.calculate.CalculateModule
import com.example.mykotlinapplication.features.success.SuccessFragment
import com.example.mykotlinapplication.features.success.SuccessModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector(modules = [CalculateModule::class])
    abstract fun contributeFragmentAndroidInjector(): CalculateFragment

    @ContributesAndroidInjector(modules = [SuccessModule::class])
    abstract fun contributeSuccessFragmentAndroidInjector(): SuccessFragment
}
