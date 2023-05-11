package com.zuhal.discovergames.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailReward : Screen("detail")
    object About: Screen("about")
}