package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.RetrofitInstance
import com.example.pokedexapp.data.model.PokemonDetail
import com.example.pokedexapp.data.model.PokemonListItem

class PokemonRepository {

    private val api = RetrofitInstance.api

    suspend fun getPokemonList(): Result<List<PokemonListItem>> {
        return try {
            val response = api.getPokemonList(limit = 151)
            Result.success(response.results)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(name: String): Result<PokemonDetail> {
        return try {
            val response = api.getPokemonDetail(name)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchPokemon(query: String): Result<List<PokemonListItem>> {
        return try {
            val response = api.getPokemonList(limit = 151)
            val filtered = response.results.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.id.toString().contains(query)
            }
            Result.success(filtered)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

