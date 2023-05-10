package com.zuhal.discovergames.di

import android.content.Context
import com.example.githubusers.utils.AppExecutors
import com.zuhal.discovergames.data.GameRepository
import com.zuhal.discovergames.data.local.room.FavoriteGameDatabase

object Injection {
    fun provideRepository(context: Context): GameRepository {
        val database = FavoriteGameDatabase.getInstance(context)
        val dao = database.favoriteGameDao()
        return GameRepository.getInstance(dao)
    }
}