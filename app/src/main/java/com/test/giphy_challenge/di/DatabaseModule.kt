package com.example.movieskotlin.di

import android.app.Application
import androidx.room.Room
import com.test.giphy_challenge.database.TrendingGifDao
import com.test.giphy_challenge.database.GifDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): GifDatabase {
        return Room.databaseBuilder(application, GifDatabase::class.java, "trendings")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: GifDatabase): TrendingGifDao {
        return database.trendingGifDao
    }



    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }

}
