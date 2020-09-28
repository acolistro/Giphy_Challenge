package com.test.giphy_challenge

import android.app.Application
import com.example.movieskotlin.di.databaseModule
import com.test.giphy_challenge.di.netModule
import com.test.giphy_challenge.di.repositoryModule
import com.test.giphy_challenge.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        /**
         * Start Koin
         */
        startKoin {
            androidContext(this@MyApplication)
            androidLogger(Level.NONE)
            modules(listOf(viewModelModule, repositoryModule, netModule, databaseModule))
        }
    }
}