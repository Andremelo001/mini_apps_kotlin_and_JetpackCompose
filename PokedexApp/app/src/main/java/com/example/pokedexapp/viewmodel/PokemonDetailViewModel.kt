package com.example.pokedexapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.model.PokemonDetail
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch

sealed class PokemonDetailState {
    object Loading : PokemonDetailState()
    data class Success(val pokemon: PokemonDetail) : PokemonDetailState()
    data class Error(val message: String) : PokemonDetailState()
}

class PokemonDetailViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _state = mutableStateOf<PokemonDetailState>(PokemonDetailState.Loading)
    val state: State<PokemonDetailState> = _state

    fun loadPokemonDetail(name: String) {
        viewModelScope.launch {
            _state.value = PokemonDetailState.Loading
            val result = repository.getPokemonDetail(name)
            result.onSuccess { pokemon ->
                _state.value = PokemonDetailState.Success(pokemon)
            }.onFailure { exception ->
                _state.value = PokemonDetailState.Error(
                    exception.message ?: "Erro ao carregar detalhes do Pokémon"
                )
            }
        }
    }

    fun retry(name: String) {
        loadPokemonDetail(name)
    }
}

