package com.example.mykotlinapplication.features.success

import android.os.Bundle
import javax.inject.Inject

/**
 * Success VIPER Presenter Implementation
 */
class SuccessPresenter @Inject constructor(
        private val interactor: SuccessContract.InteractorInput,
        private val router: SuccessContract.Router
) : SuccessContract.Presenter, SuccessContract.InteractorOutput {
    override fun goBack() {
        router.showHome()
    }

    // region viper lifecycle

    override fun attachView(view: SuccessContract.View) {
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
