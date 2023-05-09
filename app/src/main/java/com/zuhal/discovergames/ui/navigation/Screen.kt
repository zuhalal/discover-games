package com.zuhal.discovergames.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
}