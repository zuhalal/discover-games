package com.zuhal.discovergames.data

import com.zuhal.discovergames.data.fake.FakeGameDataSource
import com.zuhal.discovergames.data.fake.models.Game
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity
import com.zuhal.discovergames.data.local.room.FavoriteGameDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GameRepository private constructor(
    private val dao: FavoriteGameDao,
){
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
                        description = it.description,
                        ratingsCount = it.ratingsCount,
                        esrbRating = it.esrbRating
                    )
                )
            }
        }
    }

    fun getAllGames(): Flow<List<Game>> {
        return flowOf(games)
    }

    fun getAllFavoriteGames() = dao.getFavoriteGames()

    suspend fun setFavoriteGame(game: FavoriteGameEntity) = dao.insertOneFavoriteGame(game)

    suspend fun removeFavoriteGame(id: Int) = dao.deleteFavoriteGame(id)

    companion object {
        @Volatile
        private var instance: GameRepository? = null
        fun getInstance(
            dao: FavoriteGameDao,
        ): GameRepository =
            instance ?: synchronized(this) {
                instance ?: GameRepository(dao)
            }.also { instance = it }
    }
}