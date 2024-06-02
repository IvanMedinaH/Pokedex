package com.realform.macropaytestpokemon.presentation.ui.pokedex.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.detail.PokeMonDetails
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Pokedex
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexDetailRepository
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokedexDetailViewModel(private val auth: FirebaseAuth, private val repository: IPokedexDetailRepository):ViewModel(){

    // Estado de la petición
    private val _pokemon = MutableLiveData<PokeMonDetails>()
    val pokemon: MutableLiveData<PokeMonDetails> get() = _pokemon

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    init {
        // if (UserSession.isLoggedIn()) {
        _isLoggedIn.value = true
        //  }
    }

     fun loadPokemonDetail(id:String) {
            _isLoading.value = true
            // Realizar la llamada a la API en un hilo de fondo
            viewModelScope.launch(Dispatchers.IO) {
                when (val result = repository.getPokemonDetails(id)) {
                    is ResultAPI.Error -> {
                        withContext(Dispatchers.Main) {
                            Log.d("ERROR", "No podemos mostrar pokemones")
                            _isLoading.value = false
                        }
                    }
                    is ResultAPI.Success -> {
                        withContext(Dispatchers.Main) {
                            _pokemon.value = result.data
                            _isLoading.value = false
                        }
                    }
                }
            }
    }


}