package com.zuhal.discovergames.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuhal.discovergames.data.GameRepository
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity
import com.zuhal.discovergames.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: GameRepository) : ViewModel() {
    private val _isFavoriteState: MutableStateFlow<UiState<Boolean>> =
        MutableStateFlow(UiState.Loading)
    val isFavoriteState: StateFlow<UiState<Boolean>>
        get() = _isFavoriteState

    fun isGameFavorite(id: Int) {
        viewModelScope.launch {
            repository.isGameFavorite(id).catch {
                _isFavoriteState.value = UiState.Error(it.message.toString())
            }.collect {
                _isFavoriteState.value = UiState.Success(it)
            }
        }
    }

    fun setIsFavorite(id: Int) {
        viewModelScope.launch {
            repository.setFavoriteGame(FavoriteGameEntity(id))
        }
    }

    fun removeFromFavorite(id: Int) {
        viewModelScope.launch {
            repository.removeFavoriteGame(id)
        }
    }
}