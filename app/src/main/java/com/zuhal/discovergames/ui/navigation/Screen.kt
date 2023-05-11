package com.zuhal.discovergames.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object DetailReward : Screen("Detail")
    object About: Screen("About")
}