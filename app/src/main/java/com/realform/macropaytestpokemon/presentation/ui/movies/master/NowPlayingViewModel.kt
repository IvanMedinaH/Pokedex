package com.realform.macropaytestpokemon.presentation.ui.movies.master

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.core.session.UserSession
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.nowPlayingModel.master.NowPlaying
import com.realform.macropaytestpokemon.domain.repository.nowPlaying.IMoviesNowPlayingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NowPlayingViewModel(private val auth: FirebaseAuth, private val repository: IMoviesNowPlayingRepository) : ViewModel() {

    // Estado de la petición
    private val _nowPlaying = MutableLiveData<NowPlaying?>()
    val nowPlayingState: MutableLiveData<NowPlaying?> get() = _nowPlaying

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    init {
        if (UserSession.isLoggedIn()) {
            _isLoggedIn.value = true
        }
    }

    fun setLoggedInStatus(isLoggedIn: Boolean) {
        _isLoggedIn.value = isLoggedIn
    }

    fun signOut() {
        UserSession.signOut(auth)
    }

    fun loadNowPlayingMovies() {
        _isLoading.value = true
        // Realizar la llamada a la API en un hilo de fondo
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getAllMoviesNowPlaying()) {
                is ResultAPI.Error -> withContext(Dispatchers.Main) {
                    Log.d("ERROR", "error en la petición")
                }

                is ResultAPI.Success -> {
                    withContext(Dispatchers.Main) {
                        _nowPlaying.value = result.data
                        _isLoading.value = false
                    }
                }
            }
        }
    }


}
