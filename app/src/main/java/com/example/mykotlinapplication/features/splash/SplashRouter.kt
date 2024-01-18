package com.example.mykotlinapplication.features.splash

import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.calculate.CalculateFragment
import com.example.mykotlinapplication.features.success.SuccessFragment
import javax.inject.Inject

class SplashRouter
    @Inject
    constructor(private val fragment: SplashFragment) :
    SplashContract.Router {

    override fun showHome() {
        replaceFragment()
    }

    private fun replaceFragment() {
        fragment.parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, CalculateFragment())
            commit()
        }
    }
}

