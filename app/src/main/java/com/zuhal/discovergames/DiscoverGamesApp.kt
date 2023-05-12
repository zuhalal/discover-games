package com.zuhal.discovergames

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.navigation.Screen
import com.zuhal.discovergames.ui.screen.about.AboutScreen
import com.zuhal.discovergames.ui.screen.detail.DetailScreen
import com.zuhal.discovergames.ui.screen.favorite.FavoriteScreen
import com.zuhal.discovergames.ui.screen.home.HomeScreen
import com.zuhal.discovergames.ui.theme.DiscoverGamesTheme
import com.zuhal.discovergames.ui.components.elements.BottomBar

@Composable
fun DiscoverGamesApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !== Screen.Detail.route) {
                BottomBar(navController)
            }
        },
        topBar = {
            if (currentRoute !== Screen.Detail.route) {
                TopAppBar(
                    title = { Text(stringResource(id = R.string.app_name)) },
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { game ->
                        navBackStackEntry?.savedStateHandle?.set("game", game)
                        navController.navigate(Screen.Detail.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(
                route = Screen.Detail.route,
            ) {
                val game = navController.previousBackStackEntry?.savedStateHandle?.get<Game>("game")
                game?.let {
                    val context = LocalContext.current

                    DetailScreen(
                        game = game,
                        navigateBack = { navController.navigateUp() },
                        onShareButtonClicked = { slug ->
                            shareGame(context, slug)
                        }
                    )
                }
            }

            composable(Screen.About.route) {
                AboutScreen()
            }

            composable(Screen.Favorite.route) {
                FavoriteScreen(
                    navigateToDetail = { game ->
                        navBackStackEntry?.savedStateHandle?.set("game", game)
                        navController.navigate(Screen.Detail.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

private fun shareGame(context: Context, slug: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.share_game))
        putExtra(Intent.EXTRA_TEXT, slug)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.share_game)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiscoverGamesTheme(darkTheme = true) {
        DiscoverGamesApp()
    }
}