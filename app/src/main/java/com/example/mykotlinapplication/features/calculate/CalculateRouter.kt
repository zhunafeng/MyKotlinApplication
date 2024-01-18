package com.example.mykotlinapplication.features.calculate

import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.failure.FailureFragment
import com.example.mykotlinapplication.features.splash.SplashContract
import com.example.mykotlinapplication.features.splash.SplashFragment
import com.example.mykotlinapplication.features.success.SuccessFragment
import javax.inject.Inject

/**
 * Calculate VIPER Router Implementation
 */
class CalculateRouter
    @Inject
    constructor(private val fragment: CalculateFragment) : CalculateContract.Router {

        override fun showFailure() {

            fragment.parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view, FailureFragment())
                commit()
            }

        }

       override fun showResult() {
            replaceFragment()
        }

    private fun replaceFragment() {
        fragment.parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, SuccessFragment())
            commit()
        }
    }

    }
