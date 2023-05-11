package com.zuhal.discovergames.ui.screen.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuhal.discovergames.data.GameRepository
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity
import com.zuhal.discovergames.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: GameRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Game>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Game>>>
        get() = _uiState

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun getAllFavoriteGames() {
        viewModelScope.launch {
            repository.getAllFavoriteGames()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { favGame ->
                    repository.getAllGames()
                        .catch {
                            _uiState.value = UiState.Error(it.message.toString())
                        }
                        .collect { listGame ->
                            val filtered =
                                listGame.filter { favGame.contains(FavoriteGameEntity(it.id)) }
                            _uiState.value = UiState.Success(filtered)
                        }
                }
        }
    }

    fun searchGames(query: String) {
        _query.value = query
        viewModelScope.launch {
            repository.getAllFavoriteGames()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { favGame ->
                    repository.getAllGames()
                        .catch {
                            _uiState.value = UiState.Error(it.message.toString())
                        }
                        .collect { listGame ->
                            val filtered =
                                listGame.filter { favGame.contains(FavoriteGameEntity(it.id)) }
                            _uiState.value = UiState.Success(filtered.filter {
                                it.name.contains(
                                    query,
                                    ignoreCase = true
                                )
                            })
                        }
                }
        }
    }
}