package com.zuhal.discovergames.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuhal.discovergames.data.GameRepository
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GameRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Game>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Game>>>
        get() = _uiState

    fun getAllGames() {
        viewModelScope.launch {
            repository.getAllGames()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { listGame ->
                    _uiState.value = UiState.Success(listGame)
                }
        }
    }
}