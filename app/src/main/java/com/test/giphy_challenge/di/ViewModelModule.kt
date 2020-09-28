package com.test.giphy_challenge.di

import com.test.giphy_challenge.viewmodel.TrendingGifsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TrendingGifsViewModel(get()) }
}
