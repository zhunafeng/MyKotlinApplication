package com.example.mykotlinapplication.features.success

import android.os.Bundle
import javax.inject.Inject

/**
 * Success VIPER Interactor Implementation
 */
class SuccessInteractor
    @Inject
    constructor() : SuccessContract.InteractorInput {
        // region viper lifecycle

        override fun attachOutput(output: SuccessContract.InteractorOutput) {
        }

        override fun detachOutput() {
        }

        override fun loadData(savedState: Bundle?) {
            // TODO implement this. Call output with results of a data load or load existing state
        }

        override fun savePendingState(outState: Bundle) {
            // TODO save interactor state to bundle and output success if required
        }

        // endregion

        // region interactor inputs

        // endregion
    }
