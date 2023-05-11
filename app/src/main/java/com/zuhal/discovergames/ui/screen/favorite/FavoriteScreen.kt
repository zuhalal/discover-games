package com.zuhal.discovergames.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.di.Injection
import com.zuhal.discovergames.ui.ViewModelFactory
import com.zuhal.discovergames.ui.common.UiState
import com.zuhal.discovergames.ui.components.content.HomeContent

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToDetail: (Game) -> Unit,
) {
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                if (query !== "") {
                    viewModel.searchFavoriteGames(query)
                } else {
                    viewModel.getAllFavoriteGames()
                }
            }
            is UiState.Success -> {
                HomeContent(
                    games = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    query = query,
                    onQueryChange = viewModel::searchFavoriteGames
                )
            }
            is UiState.Error -> {}
        }
    }
}