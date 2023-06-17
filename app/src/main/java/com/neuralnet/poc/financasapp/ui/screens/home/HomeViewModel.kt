package com.neuralnet.poc.financasapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuralnet.poc.financasapp.data.model.Despesa
import com.neuralnet.poc.financasapp.data.model.Gestor
import com.neuralnet.poc.financasapp.data.network.PocFinancasApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.descriptors.listSerialDescriptor
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pocFinancasApi: PocFinancasApi,
) : ViewModel() {

    private val _gestores = MutableStateFlow<List<Gestor>>(listOf())

    val gestores: StateFlow<List<Gestor>> = _gestores

    private val _despesas = MutableStateFlow<List<Despesa>>(listOf())

    val despesas: StateFlow<List<Despesa>> = _despesas

    init {
        listarDespesas()
    }

    private fun listarGestores() = viewModelScope.launch {
        _gestores.update {
            pocFinancasApi.listarGestores()
        }
    }

    private fun listarDespesas() = viewModelScope.launch {
        _despesas.update {
            pocFinancasApi.listarDespesas()
        }
    }
}