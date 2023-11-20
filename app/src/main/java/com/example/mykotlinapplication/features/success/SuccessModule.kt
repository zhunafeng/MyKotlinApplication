package com.example.mykotlinapplication.features.success

import dagger.Module
import dagger.Provides

/**
 * Success VIPER Dagger Module
 */
@Module
class SuccessModule() {

    @Provides
    fun providePresenter(impl: SuccessPresenter): SuccessContract.Presenter = impl

    @Provides
    fun provideInteractor(impl: SuccessInteractor): SuccessContract.InteractorInput = impl

    @Provides
    fun provideRouter(impl: SuccessRouter): SuccessContract.Router = impl

}
