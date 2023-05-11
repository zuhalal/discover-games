package com.zuhal.discovergames.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Detail : Screen("Detail")
    object About: Screen("About")
    object Favorite: Screen("Favorite")
}