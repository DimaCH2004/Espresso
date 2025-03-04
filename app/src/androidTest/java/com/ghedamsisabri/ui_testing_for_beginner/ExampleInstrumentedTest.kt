package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPage() {
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()
        isTextOnScreen("SecondaryActivity")
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText(5))
    }
    @Test
    fun firstTestCase(){
        mainPageView.isViewDisplayed()
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()
        isTextOnScreen("SecondaryActivity")
        BackBtn.isViewDisplayed()

    }
    @Test
    fun secondTestCase(){
        mainPageView.isViewDisplayed()
        NextBtn.tap()
        BackBtn.tap()
        NextBtn.isViewDisplayed()
        isTextOnScreen("MainActivity")
        firstPageActivity.isViewDisplayed()
    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val BackBtn: Matcher<View> by lazy { withId(R.id.button_back) }
        val firstPageActivity: Matcher<View> by lazy { withId(R.id.activity_main_title) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val mainPageView: Matcher<View> by lazy { withId(R.id.main) }
    }


}