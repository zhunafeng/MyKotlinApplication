package com.example.mykotlinapplication.di

import android.app.Application
import com.example.mykotlinapplication.features.calculate.CalculateModule
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Interface with annotation @Component will make Dagger generate
 * a graph where Dagger will find out dependencies as needs
 *
 *
 */
@Component(modules = [AndroidInjectionModule::class])
interface ApplicationGraph{

    fun inject(application: Application)

}