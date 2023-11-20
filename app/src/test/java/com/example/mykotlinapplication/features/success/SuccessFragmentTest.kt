//package com.example.mykotlinapplication.features.Success
//
//import androidx.lifecycle.Lifecycle
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.anonyome.<insert-project>.ui.common.BaseTests
//import com.anonyome.<insert-project>.ui.common.launchFragmentScenario
//import com.anonyome.<insert-project>.ui.common.setupInjection
//import io.kotest.matchers.shouldNotBe
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.kotlin.*
//import org.robolectric.annotation.Config
//
//@RunWith(AndroidJUnit4::class)
//@Config(application = TestApplication::class)
//class SuccessFragmentTest : BaseTests() {
//
//    private val presenter by before { mock<SuccessPresenter>() }
//    private lateinit var fragment: SuccessFragment
//    private val scenario by before {
//        setupInjection<SuccessFragment> { it.presenter = presenter }
//        launchFragmentScenario<SuccessFragment> { fragment = it }
//    }
//
//    @Before
//    fun setup() {
//        // Verify the fragment is injected and that the presenter is assigned.
//        verify(presenter).attachView(eq(fragment))
//        verify(presenter).viewLoaded(anyOrNull())
//        fragment.presenter shouldNotBe null
//    }
//
//    @After
//    fun tearDown() {
//        // Catch all unverified interactions
//        verifyNoMoreInteractions(presenter)
//    }
//
//    @Test
//    fun `VIPER detaches from fragment`() {
//        scenario.moveToState(Lifecycle.State.DESTROYED)
//
//        // Verify that the presenter is assigned.
//        verify(presenter).detachView()
//    }
//
//    @Test
//    fun `fragment robolectric tests required`() {
//        Assert.fail("Fragment unit tests have not been implemented for Success. Replace this method with actual tests.")
//    }
//}