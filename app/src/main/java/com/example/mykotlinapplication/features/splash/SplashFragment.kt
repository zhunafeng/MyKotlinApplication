package com.example.mykotlinapplication.features.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.FragmentSplashBinding
import com.example.mykotlinapplication.features.calculate.CalculateFragment
import com.example.mykotlinapplication.features.success.SuccessContract
import com.example.mykotlinapplication.features.success.SuccessFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SplashFragment : Fragment(), SplashContract.View, View.OnClickListener {

    @Inject
    internal lateinit var presenter: SplashContract.Presenter

    @VisibleForTesting
    internal lateinit var binding: FragmentSplashBinding

    // If this VIPER module has args then add it to the navigation graph and uncomment these lines.
    // @VisibleForTesting
    // internal val args by navArgs<SuccessFragmentFragmentArgs>()

    // region viper lifecycle

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)

        presenter.attachView(this)
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)

        // TODO setup view, event listeners etc.
        binding.continueBtn.setOnClickListener(this)

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

    private fun replaceFragment() {
//        // simplify the codes by using scope function
//        requireActivity().supportFragmentManager.beginTransaction().apply {
//            add(R.id.fragment_container_view, CalculateFragment())
//            commit()
//        }
        presenter.goToCalculateFragment()
    }
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.continueBtn -> {
                replaceFragment()
            }

        }
    }
}