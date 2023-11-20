package com.example.mykotlinapplication.features.calculate

import android.os.Bundle
import com.example.mykotlinapplication.base.ObjectDelegate
import javax.inject.Inject

/**
 * Calculate VIPER Presenter Implementation
 */
class CalculatePresenter @Inject constructor(
    private val interactor: CalculateContract.InteractorInput,
    private val router: CalculateContract.Router
) : CalculateContract.Presenter, CalculateContract.InteractorOutput {

    // region viper lifecycle
//    @Inject
//    internal lateinit var view: CalculateContract.View
    internal val viewDelegate = ObjectDelegate<CalculateContract.View>()
    internal val view by viewDelegate

    override fun attachView(view: CalculateContract.View) {
        interactor.attachOutput(this)
    }

    override fun detachView() {
        interactor.detachOutput()
    }

    override fun viewLoaded(savedState: Bundle?) {
        interactor.loadData(savedState)
    }

    override fun saveState(outState: Bundle) {
        interactor.savePendingState(outState)
    }

    override fun calcEquals(inputs: String) {
        interactor.calculateResult(inputs)
    }

    override fun loadDataResult(calcResult: String) {
        view.setResult(calcResult)

        // TODO handle result
    }

    override fun clearDataResult(calcResult: String) {
        view.clearResult(calcResult)
    }

    override fun allClear(inputs: String) {
        interactor.clearResult(inputs)

    }

    // TODO Add interactor outputs

    // endregion

}
