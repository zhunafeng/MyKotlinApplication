package com.example.mykotlinapplication

import com.sudoplatform.applicationkit.core.util.coroutines.AnonyomeCoroutineScope
import com.example.mykotlinapplication.features.calculate.CalculateContract
import com.example.mykotlinapplication.features.calculate.CalculateInteractor

insert-project>.ui.common.BaseTests
import io.kotest.matchers.shouldBe
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions

class CalculateInteractorTest : BaseTests() {

    private val coroutineScopeSpy: AnonyomeCoroutineScope by before {
        spy(AnonyomeCoroutineScope(dispatchers = TestDispatcherProvider()))
    }

    private val interactor: CalculateInteractor by before {
        CalculateInteractor(coroutineScopeSpy)
    }

    private val output by before {
        mock<CalculateContract.InteractorOutput>()
    }

    @Before
    fun setup() {
        interactor.attachOutput(output)

        // Verify output attaches after interactor is attached
        interactor.outputDelegate.isAttached() shouldBe true
    }

    @After
    fun tearDown() {
        interactor.detachOutput()

        // Verify output detaches after interactor is detached and coroutine scope is cleaned up
        interactor.outputDelegate.isAttached() shouldBe false
        verify(interactor.coroutineScope).cancelJobs()

        // Catch all unverified interactions. Add any other mocks here
        verifyNoMoreInteractions(output)
    }

    @Test
    fun `interactor test required`() {
        Assert.fail("Interactor unit tests have not been implemented for Calculate. Replace this method with actual tests.")
    }
}