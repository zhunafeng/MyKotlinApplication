package com.example.mykotlinapplication.features.success

import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.calculate.CalculateFragment
import javax.inject.Inject

/**
 * Success VIPER Router Implementation
 */
class SuccessRouter
    @Inject
    constructor(private val fragment: SuccessFragment) :
    SuccessContract.Router {
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
