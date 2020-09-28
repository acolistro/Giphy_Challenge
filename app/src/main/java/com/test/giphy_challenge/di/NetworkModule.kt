package com.test.giphy_challenge.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.test.giphy_challenge.network.Constants
import com.test.giphy_challenge.network.Service
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netModule = module {

    fun provideHttpClient(): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideUserApi(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

    single { provideHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get()) }
    single { provideUserApi(get()) }
}
