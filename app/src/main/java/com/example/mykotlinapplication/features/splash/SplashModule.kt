package com.example.mykotlinapplication.features.splash

import com.example.mykotlinapplication.features.success.SuccessContract
import com.example.mykotlinapplication.features.success.SuccessInteractor
import com.example.mykotlinapplication.features.success.SuccessPresenter
import com.example.mykotlinapplication.features.success.SuccessRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule() {
    @Provides
    fun providePresenter(impl: SplashPresenter): SplashContract.Presenter = impl

    @Provides
    fun provideInteractor(impl: SplashInteractor): SplashContract.InteractorInput = impl

    @Provides
    fun provideRouter(impl: SplashRouter): SplashContract.Router = impl
}