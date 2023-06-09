package com.zuhal.discovergames.data.local.room

import androidx.room.*
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGameDao {
    @Query("SELECT * FROM favorite_game")
    fun getFavoriteGames(): Flow<List<FavoriteGameEntity>>

    @Query("SELECT EXISTS(SELECT * FROM favorite_game WHERE id = :id)")
    fun isGameFavorite(id: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOneFavoriteGame(favoriteGame: FavoriteGameEntity)

    @Query("DELETE FROM favorite_game WHERE id = :id")
    suspend fun deleteFavoriteGame(id: Int)
}