package com.example.mykotlinapplication.features.calculate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.FragmentCalculateBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Calculate VIPER Fragment Implementation
 */
class CalculateFragment : Fragment(), CalculateContract.View {

    @Inject
    internal lateinit var presenter: CalculateContract.Presenter

    @VisibleForTesting
    internal lateinit var binding: FragmentCalculateBinding

    // If this VIPER module has args then add it to the navigation graph and uncomment these lines.
    // @VisibleForTesting
    // internal val args by navArgs<CalculateFragmentFragmentArgs>()

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
        binding = FragmentCalculateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)

        // TODO setup view, event listeners etc.

        // Notify Presenter that the View is ready
        presenter.viewLoaded(savedInstanceState)
        binding.workings.text = "1+2"


        binding.equalsBtn.setOnClickListener {
            presenter.calcEquals(binding.workings.text as String)
        }

       // onClick(binding.root)

    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.saveState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun setResult(input: String) {
        binding.results.text = input
    }


//    override fun onClick(v: View?) {
//        when(v?.id) {
//            R.id.equalsBtn -> {presenter.calcEquals(binding.workings.text as String)}
//        }
//    }

    // endregion

    // region View contract

    // TODO Add view contract overrides

    // endregion

}
