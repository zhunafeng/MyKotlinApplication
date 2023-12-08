package com.example.mykotlinapplication.features.splash

import com.example.mykotlinapplication.features.success.SuccessFragment
import javax.inject.Inject

class SplashRouter
    @Inject
    constructor(private val fragment: SplashFragment) :
    SplashContract.Router {
}

