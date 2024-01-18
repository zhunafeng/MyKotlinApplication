package com.example.mykotlinapplication.features.splash

import android.os.Bundle
import com.example.mykotlinapplication.base.ObjectDelegate
import com.example.mykotlinapplication.features.calculate.CalculateContract
import com.example.mykotlinapplication.features.success.SuccessContract
import javax.inject.Inject

class SplashPresenter

    @Inject
    constructor(
        private val interactor: SplashContract.InteractorInput,
        private val router: SplashContract.Router,
    ) : SplashContract.Presenter, SplashContract.InteractorOutput {

    internal val viewDelegate = ObjectDelegate<SplashContract.View>()
    internal val view by viewDelegate

    override fun goBack() {
        TODO("Not yet implemented")
    }

    override fun attachView(view: SplashContract.View) {
        viewDelegate.attach(view)
        interactor.attachOutput(this)
    }

    // region viper lifecycle

        override fun detachView() {
            interactor.detachOutput()
            viewDelegate.detach()
        }

        override fun viewLoaded(savedState: Bundle?) {
            interactor.loadData(savedState)
        }

        override fun saveState(outState: Bundle) {
            interactor.savePendingState(outState)
        }

    override fun goToCalculateFragment() {
        router.showHome()
    }
    override fun loadDataResult() {
        }

}
