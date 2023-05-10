package com.zuhal.discovergames.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zuhal.discovergames.di.Injection
import com.zuhal.discovergames.ui.ViewModelFactory
import com.zuhal.discovergames.ui.common.UiState
import com.zuhal.discovergames.ui.components.content.HomeContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllGames()
            }
            is UiState.Success -> {
                HomeContent(
                    games = uiState.data,
                    modifier = modifier,
                )
            }
            is UiState.Error -> {}
        }
    }
}