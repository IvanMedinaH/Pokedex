package com.realform.macropaytestpokemon.presentation.ui.pocketMonster

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.realform.macropaytestpokemon.core.session.UserSession
import com.realform.macropaytestpokemon.data.utils.ResultAPI
import com.realform.macropaytestpokemon.domain.models.pokemons_dotnet.master.PocketMonster
import com.realform.macropaytestpokemon.domain.repository.pokedexRepository.IPocketmonsterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PocketMonsterViewModel(private val auth: FirebaseAuth, private val repository: IPocketmonsterRepository): ViewModel() {

    // Estado de la petición
    private val _pokemonos = MutableLiveData<List<PocketMonster>>()
    val pokemonos: MutableLiveData<List<PocketMonster>> get() = _pokemonos

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

    fun setPokemons(pokemonos:List<PocketMonster>){
        _pokemonos.value = pokemonos
    }

    fun getPokemonos(): List<PocketMonster> {
        return _pokemonos.value ?: emptyList()
    }


    private var allPokemons = mutableListOf<PocketMonster>()

    fun loadAllPokemons() {
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getAllPokemons()) {

                is ResultAPI.Success -> {
                    withContext(Dispatchers.Main) {
                        allPokemons.addAll(result.data)

                        // Imprimir los Pokémon en el log
                        result.data.forEach { pokemon ->
                            Log.d("POCKETMONSTERS", "Pokemon: ${pokemon.name}, Type: ${pokemon.type}")
                        }

                        _pokemonos.value = allPokemons
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
