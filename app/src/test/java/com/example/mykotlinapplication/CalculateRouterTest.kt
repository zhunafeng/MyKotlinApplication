package com.example.mykotlinapplication

import com.example.mykotlinapplication.features.calculate.CalculateRouter

insert-project>.ui.common.BaseTests
import org.junit.After
import org.junit.Assert
import org.junit.Test

class CalculateRouterTest : BaseTests() {

    private val router by before {
        CalculateRouter()
    }

    @After
    fun tearDown() {
        // Catch all unverified interactions.
        // verifyNoMoreInteractions() // TODO: Add any other mocks here and uncomment line
    }

    @Test
    fun `router test required`() {
        Assert.fail("Router unit tests have not been implemented for Calculate. Replace this method with actual tests.")
    }
}
