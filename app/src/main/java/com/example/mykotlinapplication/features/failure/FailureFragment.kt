package com.example.mykotlinapplication.features.failure

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FailureFragment : Fragment() {
    @Inject
    internal lateinit var viewModelFactory: FailureViewModelFactory

    @Inject
    internal lateinit var router: FailureRouter

    /** View model for the compose view */

    private val viewModel by viewModels<FailureViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    internal fun inject() {
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                // The delete account screen bound to the provider
                    FailureScreen(
                        uiState = viewModel.uiState.value,
                        onBackClicked = ::onBackClicked
                    )
            }
        }
    }

    @VisibleForTesting
    internal fun onBackClicked() {
        router.showHome()
    }



}