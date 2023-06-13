package com.neuralnet.poc.financasapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuralnet.poc.financasapp.data.model.Gestor
import com.neuralnet.poc.financasapp.data.network.PocFinancasApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pocFinancasApi: PocFinancasApi,
) : ViewModel() {

    private val _gestores = MutableStateFlow<List<Gestor>>(listOf())

    val gestores: StateFlow<List<Gestor>> = _gestores

    init {
        listarGestores()
    }

    private fun listarGestores() = viewModelScope.launch {
        _gestores.update {
            pocFinancasApi.listarGestores()
        }
    }
}