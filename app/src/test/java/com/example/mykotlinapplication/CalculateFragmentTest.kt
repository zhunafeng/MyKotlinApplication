//package com.example.mykotlinapplication
//
//import androidx.lifecycle.Lifecycle
//import com.example.mykotlinapplication.features.calculate.CalculateFragment
//import com.example.mykotlinapplication.features.calculate.CalculatePresenter
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
//class CalculateFragmentTest : BaseTests() {
//
//    private val presenter by before { mock<CalculatePresenter>() }
//    private lateinit var fragment: CalculateFragment
//    private val scenario by before {
//        setupInjection<CalculateFragment> { it.presenter = presenter }
//        launchFragmentScenario<CalculateFragment> { fragment = it }
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
//        Assert.fail("Fragment unit tests have not been implemented for Calculate. Replace this method with actual tests.")
//    }
//}