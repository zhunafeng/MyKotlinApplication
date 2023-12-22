package com.example.mykotlinapplication.features.failure

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FailureFragment : Fragment() {
    @Inject
    internal lateinit var viewModelFactory: FailureViewModelFactory

    @Inject
    internal lateinit var router: FailureRouter

   // private val viewModel by viewModels<FailureViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    internal fun inject() {
        AndroidSupportInjection.inject(this)
    }



}