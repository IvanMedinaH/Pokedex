package com.realform.macropaytestpokemon.presentation.ui.pokedex.master

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.core.session.UserSession
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Pokedex
import com.realform.macropaytestpokemon.domain.models.pokemons.master.Result
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPokedexRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokedexViewModel(private val auth: FirebaseAuth, private val repository: IPokedexRepository): ViewModel() {

    // Estado de la petición
    private val _pokemonos = MutableLiveData<Pokedex>()
    val pokemonos: MutableLiveData<Pokedex> get() = _pokemonos

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    init {
       // if (UserSession.isLoggedIn()) {
            _isLoggedIn.value = true
      //  }
       // loadAllPokemons()
    }


    fun setLoggedInStatus(isLoggedIn: Boolean) {
        _isLoggedIn.value = isLoggedIn
    }

    fun signOut() {
        UserSession.signOut(auth)
    }

    fun setPokemons(pokemonos:Pokedex){
       _pokemonos.value = pokemonos
    }

    fun getPokemonos(): Pokedex {
        return _pokemonos.value ?: Pokedex(emptyList())
    }

    //paginacion datos
    private val limit = 10
    private var offset = 0
    private var allPokemons = mutableListOf<Result>()

    fun loadAllPokemons() {
        _isLoading.value = true
        // Realizar la llamada a la API en un hilo de fondo
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getAllPokemons(offset = offset, limit = limit)) {

                is ResultAPI.Success -> {
                    withContext(Dispatchers.Main) {
                        allPokemons.addAll(result.data.results)
                        _pokemonos.value = Pokedex(allPokemons)
                        offset += limit
                        _isLoading.value = false
                    }
                }

                is ResultAPI.Error -> {
                    withContext(Dispatchers.Main) {
                        Log.d("ERROR", "No podemos mostrar pokemones")
                        _isLoading.value = false
                    }
                }
            }
        }
    }
}
