package com.test.giphy_challenge.viewmodel

import androidx.lifecycle.ViewModel
import com.test.giphy_challenge.repository.GifRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException

class TrendingGifsViewModel(private val gifRepository: GifRepository) : ViewModel() {

    val trendinglist = gifRepository.gifTrending

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                gifRepository.refreshTrendingGifs()
            } catch (networkError: IOException) {
                networkError.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}