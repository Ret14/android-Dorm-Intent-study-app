package com.example.dormintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(initialState = Lifecycle.State.RESUMED)
    }

    @After
    fun tearDown() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun testIfCheckboxClickChangesCrimeField() {
        onView(withId(R.id.cbCrimeSolved)).perform(click())
        scenario.onFragment {
            assertEquals(it.crime.isSolved, true)
        }
    }

    @Test
    fun testIfEditingCrimeTitleChangesTitleFieldInCrimeClass() {
        val crimeTitle = "Bad crime"
        onView(withId(R.id.etCrimeTitle)).perform(typeText(crimeTitle))
        scenario.onFragment {
            assertEquals(it.crime.title, crimeTitle)
        }
    }
}