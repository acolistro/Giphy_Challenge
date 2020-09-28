package com.test.giphy_challenge.di


import com.test.giphy_challenge.database.GifDatabase
import com.test.giphy_challenge.network.Service
import com.test.giphy_challenge.repository.GifRepository
import org.koin.dsl.module

val repositoryModule = module {

    fun provideTrendingRepository(api: Service, dao: GifDatabase): GifRepository {
        return GifRepository(api,dao)
    }

    single { provideTrendingRepository(get(),get()) }
}

