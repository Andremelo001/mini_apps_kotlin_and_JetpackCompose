package com.example.pokedexapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedexapp.data.model.PokemonDetail
import com.example.pokedexapp.viewmodel.PokemonDetailState
import com.example.pokedexapp.viewmodel.PokemonDetailViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemonName: String,
    viewModel: PokemonDetailViewModel,
    onBackClick: () -> Unit
) {
    LaunchedEffect(pokemonName) {
        viewModel.loadPokemonDetail(pokemonName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        pokemonName.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                        },
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        when (val state = viewModel.state.value) {
            is PokemonDetailState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is PokemonDetailState.Success -> {
                PokemonDetailContent(
                    pokemon = state.pokemon,
                    modifier = Modifier.padding(padding)
                )
            }

            is PokemonDetailState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = state.message,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(onClick = { viewModel.retry(pokemonName) }) {
                            Text("Tentar novamente")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonDetailContent(
    pokemon: PokemonDetail,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagem do Pokémon
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF5F5F5)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pokemon.sprites.other?.official_artwork?.front_default
                        ?: pokemon.sprites.front_default,
                    contentDescription = pokemon.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ID e Nome
        Text(
            text = "#${pokemon.id.toString().padStart(3, '0')}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = pokemon.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
            },
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Informações básicas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoCard(
                title = "Peso",
                value = "${pokemon.weight / 10.0} kg"
            )

            InfoCard(
                title = "Altura",
                value = "${pokemon.height / 10.0} m"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tipos
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Tipos",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pokemon.types.forEach { typeSlot ->
                        TypeChip(type = typeSlot.type.name)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Habilidades
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Habilidades",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                pokemon.abilities.forEach { abilitySlot ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "• ${abilitySlot.ability.name.replace("-", " ").replaceFirstChar { 
                                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() 
                            }}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TypeChip(type: String) {
    val typeColor = getTypeColor(type)

    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp)),
        color = typeColor
    ) {
        Text(
            text = type.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
            },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun getTypeColor(type: String): Color {
    return when (type.lowercase()) {
        "normal" -> Color(0xFFA8A878)
        "fire" -> Color(0xFFF08030)
        "water" -> Color(0xFF6890F0)
        "electric" -> Color(0xFFF8D030)
        "grass" -> Color(0xFF78C850)
        "ice" -> Color(0xFF98D8D8)
        "fighting" -> Color(0xFFC03028)
        "poison" -> Color(0xFFA040A0)
        "ground" -> Color(0xFFE0C068)
        "flying" -> Color(0xFFA890F0)
        "psychic" -> Color(0xFFF85888)
        "bug" -> Color(0xFFA8B820)
        "rock" -> Color(0xFFB8A038)
        "ghost" -> Color(0xFF705898)
        "dragon" -> Color(0xFF7038F8)
        "dark" -> Color(0xFF705848)
        "steel" -> Color(0xFFB8B8D0)
        "fairy" -> Color(0xFFEE99AC)
        else -> Color.Gray
    }
}

