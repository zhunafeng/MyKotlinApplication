package com.example.mykotlinapplication.features.calculate

import dagger.Module
import dagger.Provides

/**
 * Calculate VIPER Dagger Module
 */
@Module
class CalculateModule() {
    @Provides
    fun providePresenter(impl: CalculatePresenter): CalculateContract.Presenter = impl

    @Provides
    fun provideInteractor(impl: CalculateInteractor): CalculateContract.InteractorInput = impl

    @Provides
    fun provideRouter(impl: CalculateRouter): CalculateContract.Router = impl
}
