package com.zuhal.discovergames.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zuhal.discovergames.data.GameRepository
import com.zuhal.discovergames.ui.screen.detail.DetailViewModel
import com.zuhal.discovergames.ui.screen.favorite.FavoriteViewModel
import com.zuhal.discovergames.ui.screen.home.HomeViewModel

class ViewModelFactory(
    private val gameRepository: GameRepository,
) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(gameRepository) as T
        }

        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(gameRepository) as T
        }

        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(gameRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}