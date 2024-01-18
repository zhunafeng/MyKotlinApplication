package com.example.mykotlinapplication.features.failure

import dagger.Module
import dagger.Provides

@Module
class FailureModule {

    @Provides
    fun provideRouter(
        fragment: FailureFragment,
    ): FailureRouter = DefaultFailureRouter(fragment)

}