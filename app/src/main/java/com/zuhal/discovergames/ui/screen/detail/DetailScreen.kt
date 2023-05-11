package com.zuhal.discovergames.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.di.Injection
import com.zuhal.discovergames.ui.ViewModelFactory
import com.zuhal.discovergames.ui.common.UiState
import com.zuhal.discovergames.ui.components.content.DetailContent
import com.zuhal.discovergames.ui.components.content.HomeContent
import com.zuhal.discovergames.ui.screen.home.HomeViewModel

@Composable
fun DetailScreen(
    game: Game,
    modifier: Modifier = Modifier,
    onShareButtonClicked: (String) -> Unit,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
) {
    viewModel.isFavoriteState.collectAsState(initial = UiState.Loading).value.let { isFavorite ->
        when (isFavorite) {
            is UiState.Loading -> {
                viewModel.isGameFavorite(game.id)
            }
            is UiState.Success -> {
                DetailContent(
                    game = game,
                    modifier = modifier,
                    onShareButtonClicked = onShareButtonClicked,
                    isFavorite = isFavorite.data,
                    viewModel = viewModel
                )
            }
            is UiState.Error -> {}
        }
    }
}