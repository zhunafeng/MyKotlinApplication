package com.example.mykotlinapplication.features.failure

import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.features.calculate.CalculateFragment
import javax.inject.Inject

interface FailureRouter {

    fun showHome()


}

class DefaultFailureRouter @Inject constructor(
    private val fragment: FailureFragment
) : FailureRouter {

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