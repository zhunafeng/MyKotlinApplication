package com.example.mykotlinapplication

import com.example.mykotlinapplication.features.calculate.CalculateContract
import com.example.mykotlinapplication.features.calculate.CalculatePresenter

insert-project>.ui.common.BaseTests
import io.kotest.matchers.shouldBe
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions

class CalculatePresenterTest: BaseTests() {

    private val view: CalculateContract.View = mock()
    private val interactor: CalculateContract.InteractorInput = mock()
    private val router: CalculateContract.Router = mock()

    private val presenter: CalculatePresenter by before{
        CalculatePresenter(interactor, router)
    }

    @Before
    fun setup() {
        presenter.attachView(view)

        // Verify interactor attaches after view is attached
        presenter.viewDelegate.isAttached() shouldBe true
        verify(interactor).attachOutput(presenter)
    }

    @After
    fun tearDown() {
        presenter.detachView()

        // Verify interactor detaches after view is detached
        presenter.viewDelegate.isAttached() shouldBe false
        verify(interactor).detachOutput()

        // Catch all unverified interactions. Add any other mocks here
        verifyNoMoreInteractions(view, interactor, router)
    }

    @Test
    fun `presenter test required`() {
        Assert.fail("Presenter unit tests have not been implemented for Calculate. Replace this method with actual tests.")
    }

}