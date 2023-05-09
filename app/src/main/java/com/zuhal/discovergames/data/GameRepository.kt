package com.zuhal.discovergames.data

import com.zuhal.discovergames.data.model.FakeGameDataSource
import com.zuhal.discovergames.data.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GameRepository {
    private val games = mutableListOf<Game>()

    init {
        if (games.isEmpty()) {
            FakeGameDataSource.listGame.forEach {
                games.add(
                    Game(
                        id = it.id,
                        slug = it.slug,
                        name = it.name,
                        backgroundImage = it.backgroundImage,
                        released = it.released,
                        genres = it.genres,
                        rating = it.rating,
                        ratingsCount = it.ratingsCount
                    )
                )
            }
        }
    }

    fun getAllGames(): Flow<List<Game>> {
        return flowOf(games)
    }
}