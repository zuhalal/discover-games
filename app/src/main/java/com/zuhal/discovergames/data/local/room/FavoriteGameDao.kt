package com.zuhal.discovergames.data.local.room

import androidx.room.*
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGameDao {
    @Query("SELECT * FROM favorite_game")
    suspend fun getFavoriteGames(): Flow<List<FavoriteGameEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOneFavoriteGame(favoriteGame: FavoriteGameEntity)

    @Query("DELETE FROM favorite_game WHERE id = :id")
    suspend fun deleteFavoriteGame(id: Int)
}