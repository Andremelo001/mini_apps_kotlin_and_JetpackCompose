package com.example.pokedexapp.data.api

import com.example.pokedexapp.data.model.PokemonDetail
import com.example.pokedexapp.data.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 151,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): PokemonDetail
}

