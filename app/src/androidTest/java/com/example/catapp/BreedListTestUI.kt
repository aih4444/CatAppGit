package com.example.catapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.catapp.ui.breeds.BreedAdapter
import org.junit.Before
import org.junit.Test

class BreedListTestUI {


    private var navController  = TestNavHostController(getApplicationContext())

    @Before
    fun setUp() {
        navController = TestNavHostController(
            getApplicationContext()
        )

        launchFragmentInContainer {
            BreedListFragment().also { fragment ->

                // In addition to returning a new instance of our Fragment,
                // get a callback whenever the fragment’s view is created
                // or destroyed so that we can set the NavController
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment’s view has just been created
                        navController.setGraph(R.navigation.nav_graph)
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
    }

    @Test
    fun checkIfRecyclerViewVisible(){
        onView(withId(R.id.rv_breedlist))
            .check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewItemClick_shouldShowDetailFragment(){
        onView(withId(R.id.rv_breedlist))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BreedAdapter.BreedViewHolder>(0, click()))
        // asset
        assert(navController.currentDestination?.id == R.id.detailFragment)

    }

    @Test
    fun testNavigationToInBreedScreen() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            getApplicationContext()
        )

        // Create a graphical FragmentScenario for the TitleScreen
        val breedList = launchFragmentInContainer<BreedListFragment>()

        breedList.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // Verify that performing a click changes the NavController’s state
        assert(navController.currentDestination?.id == R.id.breedListFragment)
    }
}

