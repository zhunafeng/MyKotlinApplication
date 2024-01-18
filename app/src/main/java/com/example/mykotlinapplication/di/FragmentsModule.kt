package com.example.mykotlinapplication.di

import com.example.mykotlinapplication.features.calculate.CalculateFragment
import com.example.mykotlinapplication.features.calculate.CalculateModule
import com.example.mykotlinapplication.features.failure.FailureFragment
import com.example.mykotlinapplication.features.failure.FailureModule
import com.example.mykotlinapplication.features.splash.SplashFragment
import com.example.mykotlinapplication.features.splash.SplashModule
import com.example.mykotlinapplication.features.success.SuccessFragment
import com.example.mykotlinapplication.features.success.SuccessModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributeSplashFragmentAndroidInjector(): SplashFragment

    @ContributesAndroidInjector(modules = [CalculateModule::class])
    abstract fun contributeFragmentAndroidInjector(): CalculateFragment

    @ContributesAndroidInjector(modules = [SuccessModule::class])
    abstract fun contributeSuccessFragmentAndroidInjector(): SuccessFragment

    @ContributesAndroidInjector(modules = [FailureModule::class])
    abstract fun contributeFailureFragmentAndroidInjector(): FailureFragment
}
