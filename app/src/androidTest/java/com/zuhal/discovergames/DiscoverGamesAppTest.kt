package com.zuhal.discovergames

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.zuhal.discovergames.data.fake.FakeGameDataSource
import com.zuhal.discovergames.ui.navigation.Screen
import com.zuhal.discovergames.ui.theme.DiscoverGamesTheme
import com.zuhal.discovergames.utils.assertCurrentRouteName
import com.zuhal.discovergames.utils.onNodeWithStringId
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
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
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(11)
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
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(10)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[10].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)

        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back))
            .performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun favorite_Item_then_RemoveFavorite() {
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)

        // start add to favorite
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
            .performScrollTo()

        try {
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite))
                .assertExists()
        } catch (e: AssertionError) {
            composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
                .performClick()
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite))
                .assertExists()
        }

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).assertExists()

        // start remove from favorite
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).performClick()

        navController.assertCurrentRouteName(Screen.Detail.route)

        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
            .performScrollTo()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
            .performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.add_to_favorite))
            .assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).assertDoesNotExist()
    }

    @Test
    fun favorite_Item_then_SearchFavorite() {
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)

        // start favorite
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
            .performScrollTo()

        try {
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite))
                .assertExists()
        } catch (e: AssertionError) {
            composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
                .performClick()
            composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.remove_from_favorite))
                .assertExists()
        }

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }

        composeTestRule.onNodeWithStringId(R.string.my_favorite_games_page).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)

        // Search existing favorite games (Positive Case)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextClearance()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextInput(composeTestRule.activity.getString(R.string.existing_game))

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name)
            .assertTextContains(FakeGameDataSource.listGame[0].name)

        // Search not existing favorite game (Negative Case)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextClearance()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextInput(composeTestRule.activity.getString(R.string.not_existing_game))

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.not_found_tag))
            .assertExists()
    }

    @Test
    fun search_existing_game() {
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextClearance()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextInput(composeTestRule.activity.getString(R.string.existing_game))

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.game_list))
            .performScrollToIndex(0)
        composeTestRule.onNodeWithText(FakeGameDataSource.listGame[0].name)
            .assertTextContains(FakeGameDataSource.listGame[0].name)
    }

    @Test
    fun negative_search_not_existing_game() {
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextClearance()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.search_bar))
            .performTextInput(composeTestRule.activity.getString(R.string.not_existing_game))

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.not_found_tag))
            .assertExists()
    }

    @Test
    fun navigate_to_about_and_display_correct_information() {
        composeTestRule.onNodeWithStringId(R.string.about_me_page).performClick()
        navController.assertCurrentRouteName(Screen.About.route)

        // Assert
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.about_us_name_content_desc))
            .assertExists()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.about_us_email_content_desc))
            .assertExists()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.profile_image_content_desc))
            .assertExists()
    }

    @Test
    fun negative_rightBackStack_after_click_about_twice() {
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