package com.example.mykotlinapplication.features.calculate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.FragmentCalculateBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Calculate VIPER Fragment Implementation
 */
class CalculateFragment : Fragment(), CalculateContract.View, OnClickListener {

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

        /**
        Set binding onClickListeners
         */
        binding.equalsBtn.setOnClickListener(this)

        // Values
        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)

        // Operators
        binding.btnAdd.setOnClickListener(this)
        binding.btnMul.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

        binding.btnAC.setOnClickListener(this)
        binding.btnBackSpace.setOnClickListener(this)

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

    override fun clearResult(input: String) {
        binding.workings.text = input
        binding.results.text = input
    }

    override fun setWorkings(input: String) {
        binding.workings.append(input)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.equalsBtn -> {presenter.calcEquals(binding.workings.text.toString())}
            R.id.btnAC -> {presenter.allClear(binding.workings.text.toString())}
            R.id.btnBackSpace -> {presenter.backSpace(binding.workings.text.toString())}
            R.id.backBtn -> {presenter.backSpace(binding.workings.text.toString())} // GO BACK BUTTON (Fragment B)
            // Assigning numberToInput to respective buttons
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> {presenter.numberToInput((v as Button).text.toString())}
            // Assigning operationToInput to respective buttons
            R.id.btnAdd, R.id.btnSub, R.id.btnDiv, R.id.btnMul -> {presenter.operationToInput((v as Button).text.toString())}
        }
    }

}
