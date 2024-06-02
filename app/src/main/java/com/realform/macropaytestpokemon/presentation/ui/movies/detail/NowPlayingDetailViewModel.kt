package com.realform.macropaytestpokemon.presentation.ui.movies.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.detailLocal.NowPlayingMovieDetail
import com.realform.macropaytestpokemon.domain.repository.website.IWebNavigator
import com.realform.macropaytestpokemon.domain.repository.nowPlaying.IMoviesNowPlayingDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NowPlayingDetailViewModel(private val webNav: IWebNavigator, private val repository: IMoviesNowPlayingDetailRepository) :
    ViewModel() {
    private val _nowPlayingmovieItemDetail = MutableStateFlow<NowPlayingMovieDetail?>(null)
    val nowPlayingmovieItemDetail: StateFlow<NowPlayingMovieDetail?> get() = _nowPlayingmovieItemDetail.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()


    fun LaunchWebsite(url: String) {
        webNav.openWebsite(url)
    }

    fun getNowPlayingMovieDetail(id: String) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getNowPlayingMovieDetail(id)) {
                is ResultAPI.Error -> {
                    _isLoading.value = false
                    withContext(Dispatchers.Main) {
                        Log.d("ERROR", "error en la petición")
                    }
                }

                is ResultAPI.Success -> withContext(Dispatchers.Main) {
                    _isLoading.value = false
                    _nowPlayingmovieItemDetail.value = result.data
                    Log.d("SUCCESS_ITEM_DETAIL", result.data.title)
                }
            }
        }
    }
}
