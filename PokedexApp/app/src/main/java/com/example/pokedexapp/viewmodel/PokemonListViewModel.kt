package com.example.pokedexapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.model.PokemonListItem
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch

sealed class PokemonListState {
    object Loading : PokemonListState()
    data class Success(val pokemonList: List<PokemonListItem>) : PokemonListState()
    data class Error(val message: String) : PokemonListState()
}

class PokemonListViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _state = mutableStateOf<PokemonListState>(PokemonListState.Loading)
    val state: State<PokemonListState> = _state

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private var allPokemon: List<PokemonListItem> = emptyList()

    init {
        loadPokemonList()
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            _state.value = PokemonListState.Loading
            val result = repository.getPokemonList()
            result.onSuccess { pokemonList ->
                allPokemon = pokemonList
                _state.value = PokemonListState.Success(pokemonList)
            }.onFailure { exception ->
                _state.value = PokemonListState.Error(
                    exception.message ?: "Erro ao carregar Pokémons"
                )
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query

        if (query.isEmpty()) {
            _state.value = PokemonListState.Success(allPokemon)
        } else {
            val filtered = allPokemon.filter { pokemon ->
                pokemon.name.contains(query, ignoreCase = true) ||
                pokemon.id.toString().contains(query)
            }
            _state.value = PokemonListState.Success(filtered)
        }
    }

    fun retry() {
        loadPokemonList()
    }
}

