package com.example.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexapp.ui.screen.PokemonDetailScreen
import com.example.pokedexapp.ui.screen.PokemonListScreen
import com.example.pokedexapp.viewmodel.PokemonDetailViewModel
import com.example.pokedexapp.viewmodel.PokemonListViewModel

sealed class Screen(val route: String) {
    object PokemonList : Screen("pokemon_list")
    object PokemonDetail : Screen("pokemon_detail/{pokemonName}") {
        fun createRoute(pokemonName: String) = "pokemon_detail/$pokemonName"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) {
            val viewModel: PokemonListViewModel = viewModel()
            PokemonListScreen(
                viewModel = viewModel,
                onPokemonClick = { pokemonName ->
                    navController.navigate(Screen.PokemonDetail.createRoute(pokemonName))
                }
            )
        }

        composable(
            route = Screen.PokemonDetail.route,
            arguments = listOf(
                navArgument("pokemonName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            val viewModel: PokemonDetailViewModel = viewModel()
            PokemonDetailScreen(
                pokemonName = pokemonName,
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

