package com.example.listadecompras.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class ListaComprasViewModel : ViewModel() {
    var uiState by mutableStateOf(ListaComprasUiState())
        private set

    private val itens = mutableStateListOf<String>()

    fun adicionarItem(nome: String) {
        if (nome.isNotBlank()) {
            itens.add(nome)
            atualizarEstado()
        }
    }

    fun removerItem(index: Int) {
        itens.removeAt(index)
        atualizarEstado()
    }

    private fun atualizarEstado() {
        uiState = uiState.copy(
            itens = itens.toList(),
            contagem = itens.size
        )
    }
}
