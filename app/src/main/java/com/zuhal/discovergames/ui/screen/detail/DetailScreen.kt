package com.zuhal.discovergames.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.ViewModelFactory
import com.zuhal.discovergames.ui.common.UiState
import com.zuhal.discovergames.ui.components.content.DetailContent

@Composable
fun DetailScreen(
    game: Game,
    modifier: Modifier = Modifier,
    onShareButtonClicked: (String) -> Unit,
    navigateBack: () -> Unit,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    ),
) {
    viewModel.isFavoriteState.collectAsState(initial = UiState.Loading).value.let { isFavorite ->
        when (isFavorite) {
            is UiState.Loading -> {
                viewModel.isGameFavorite(game.id)
            }
            is UiState.Success -> {
                DetailContent(
                    id = game.id,
                    slug = game.slug,
                    esrbRating = game.esrbRating,
                    ratingsCount = game.ratingsCount,
                    backgroundImage = game.backgroundImage,
                    description = game.description,
                    genres = game.genres,
                    name = game.name,
                    rating = game.rating,
                    released = game.released,
                    modifier = modifier,
                    onShareButtonClicked = onShareButtonClicked,
                    isFavorite = isFavorite.data,
                    viewModel = viewModel,
                    onBackClick = navigateBack
                )
            }
            is UiState.Error -> {}
        }
    }
}