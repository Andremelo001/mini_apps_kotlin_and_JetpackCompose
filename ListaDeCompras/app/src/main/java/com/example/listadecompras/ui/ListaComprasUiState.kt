package com.example.listadecompras.ui

data class ListaComprasUiState(
    val itens: List<String> = emptyList(),
    val contagem: Int = 0,
    val textoCampo: String = ""
)
