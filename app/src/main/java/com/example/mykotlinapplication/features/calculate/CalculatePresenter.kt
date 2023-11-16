package com.example.mykotlinapplication.features.calculate

import android.os.Bundle
import javax.inject.Inject

/**
 * Calculate VIPER Presenter Implementation
 */
class CalculatePresenter @Inject constructor(
    private val interactor: CalculateContract.InteractorInput,
    private val router: CalculateContract.Router
) : CalculateContract.Presenter, CalculateContract.InteractorOutput {

    // region viper lifecycle

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

    override fun equals(inputs: String) {
        TODO("Not yet implemented")
    }

    // endregion

    // region view event handlers

    // TODO Add view event handlers

    // endregion

    // region interactor output

    override fun loadDataResult() {
        // TODO handle result
    }

    // TODO Add interactor outputs

    // endregion

}
