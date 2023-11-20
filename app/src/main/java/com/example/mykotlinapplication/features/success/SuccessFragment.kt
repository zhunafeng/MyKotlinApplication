package com.example.mykotlinapplication.features.success

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import dagger.android.support.AndroidSupportInjection
import androidx.fragment.app.Fragment
import com.example.mykotlinapplication.databinding.FragmentSuccessBinding
import javax.inject.Inject

/**
 * Success VIPER Fragment Implementation
 */
class SuccessFragment : Fragment(), SuccessContract.View {

    @Inject
    internal lateinit var presenter: SuccessContract.Presenter

    @VisibleForTesting
    internal lateinit var binding: FragmentSuccessBinding

    // If this VIPER module has args then add it to the navigation graph and uncomment these lines.
    // @VisibleForTesting
    // internal val args by navArgs<SuccessFragmentFragmentArgs>()

    // region viper lifecycle

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    internal fun inject() {
        // TODO inject with the default Application injector or the Kit injector if inside a UI Kit

        // App Injection:
        AndroidSupportInjection.inject(this)

        // Library Injection:
        // Sudo<Feature>UIInternal.instance?.inject(this)
    }

    // endregion

    // region view setup and state lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSuccessBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)

        // TODO setup view, event listeners etc.
        binding.backBtn.setOnClickListener{
            presenter.goBack()
        }

        // Notify Presenter that the View is ready
        presenter.viewLoaded(savedInstanceState)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.saveState(outState)
    }

    // endregion

    // region View contract

    // TODO Add view contract overrides

    // endregion

}
