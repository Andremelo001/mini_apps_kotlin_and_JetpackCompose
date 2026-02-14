package com.example.pokedexapp.data.model

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val url: String
) {
    val id: Int
        get() = url.split("/").dropLast(1).last().toInt()

    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
}

data class PokemonDetail(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeSlot>,
    val abilities: List<AbilitySlot>,
    val sprites: Sprites
)

data class TypeSlot(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class AbilitySlot(
    val slot: Int,
    val ability: Ability
)

data class Ability(
    val name: String,
    val url: String
)

data class Sprites(
    val front_default: String?,
    val other: OtherSprites?
)

data class OtherSprites(
    val official_artwork: OfficialArtwork?
)

data class OfficialArtwork(
    val front_default: String?
)

