package com.example.mykotlinapplication.features.splash

import android.os.Bundle
import com.example.mykotlinapplication.base.ObjectDelegate
import com.example.mykotlinapplication.features.calculate.CalculateContract
import com.example.mykotlinapplication.features.success.SuccessContract
import javax.inject.Inject


class SplashInteractor
    @Inject
    constructor() : SplashContract.InteractorInput {

    internal val outputDelegate = ObjectDelegate<CalculateContract.InteractorOutput>()
    internal val output by outputDelegate
    override fun attachOutput(output: SplashContract.InteractorOutput) {
        outputDelegate.attach(output)
    }

    override fun detachOutput() {
        outputDelegate.detach()
    }

    override fun loadData(savedState: Bundle?) {
        // TODO implement this. Call output with results of a data load or load existing state
    }

    override fun savePendingState(outState: Bundle) {
        // TODO save interactor state to bundle and output success if required
    }
}