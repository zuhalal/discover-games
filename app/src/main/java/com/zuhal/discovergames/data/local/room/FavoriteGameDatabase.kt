package com.zuhal.discovergames.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zuhal.discovergames.data.local.entity.FavoriteGameEntity

@Database(entities = [FavoriteGameEntity::class], version = 1, exportSchema = false)
abstract class FavoriteGameDatabase : RoomDatabase() {
    abstract fun favoriteGameDao(): FavoriteGameDao

    companion object {
        @Volatile
        private var instance: FavoriteGameDatabase? = null
        fun getInstance(context: Context): FavoriteGameDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteGameDatabase::class.java, "FavoriteGame.db"
                ).build()
            }
    }
}