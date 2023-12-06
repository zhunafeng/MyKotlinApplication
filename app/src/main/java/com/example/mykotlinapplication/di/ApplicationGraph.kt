package com.example.mykotlinapplication.di

import android.app.Application
import com.example.mykotlinapplication.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Interface with annotation @Component will make Dagger generate
 * a graph where Dagger will find out dependencies as needs
 *
 *
 */
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
    ],
)
interface ApplicationGraph {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun bind(): ApplicationGraph
    }

    fun inject(application: MainApplication)
}
