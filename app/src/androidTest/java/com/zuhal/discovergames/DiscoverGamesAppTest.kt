package com.zuhal.discovergames

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.zuhal.discovergames.data.fake.FakeGameDataSource
import com.zuhal.discovergames.ui.navigation.Screen
import com.zuhal.discovergames.ui.theme.DiscoverGamesTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DiscoverGamesAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            DiscoverGamesTheme(
                darkTheme = true
            ) {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                DiscoverGamesApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("GameList").performScrollToIndex(11)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[11].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[11].name).assertIsDisplayed()
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithStringId(R.string.about_me_page).performClick()
        navController.assertCurrentRouteName(Screen.About.route)

        composeTestRule.onNodeWithStringId(R.string.home_page).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("GameList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[10].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)

        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back)).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_Favorite_Item_then_RemoveFavorite() {
        composeTestRule.onNodeWithTag("GameList").performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)

        // start favorite
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button)).performScrollTo()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button)).performClick()

        try {
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite)).assertExists()
        } catch (e: AssertionError) {
            composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button)).performClick()
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite)).assertExists()
        }

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithTag("GameList").performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).assertExists()

        // start remove from favorite
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).performClick()

        navController.assertCurrentRouteName(Screen.Detail.route)

        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button)).performScrollTo()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button)).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.add_to_favorite)).assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithTag("GameList").performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).assertDoesNotExist()
    }

    @Test
    fun navHost_checkout_rightBackStack_after_click_about_twice() {
        composeTestRule.onNodeWithStringId(R.string.about_me_page).performClick()
        navController.assertCurrentRouteName(Screen.About.route)

        composeTestRule.onNodeWithStringId(R.string.about_me_page).performClick()
        navController.assertCurrentRouteName(Screen.About.route)

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        navController.assertCurrentRouteName(Screen.Home.route)
    }
}