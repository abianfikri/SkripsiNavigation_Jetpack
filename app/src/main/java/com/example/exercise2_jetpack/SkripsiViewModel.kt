package com.example.exercise2_jetpack

import androidx.lifecycle.ViewModel
import com.example.exercise2_jetpack.data.SkripsiUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SkripsiViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SkripsiUiState())
    val stateUI: StateFlow<SkripsiUiState> = _uiState.asStateFlow()

    fun setSkripsi(list: MutableList<String>) {
        _uiState.update { currenState ->
            currenState.copy(
                nama =list[0],
                nim = list[1],
                konsentrasival = list[2],
                judulSkripsi = list[3]
            )
        }
    }

    fun setDospemsatu(dosenSatu: String){
        _uiState.update { currenState->
            currenState.copy(
                dospemSatu = dosenSatu
            )
        }
    }

    fun setDospemdua(dosenDua: String){
        _uiState.update { currenState->
            currenState.copy(
                dospemDua = dosenDua
            )
        }
    }
}