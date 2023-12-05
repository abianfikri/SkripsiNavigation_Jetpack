package com.example.exercise2_jetpack.ui.navigator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exercise2_jetpack.SkripsiViewModel
import com.example.exercise2_jetpack.data.DataSkripsi
import com.example.exercise2_jetpack.ui.layout.HalamanDua
import com.example.exercise2_jetpack.ui.layout.HalamanKetiga
import com.example.exercise2_jetpack.ui.layout.HalamanSatu


enum class PengelolaHalaman {
    Home,
    Formulir,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkripsiApp(
    viewModel: SkripsiViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController(),
) {
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(
            navController = navHostController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanSatu(
                    onNextButtonClicked = {
                    navHostController.navigate(PengelolaHalaman.Formulir.name) }
                )
            }

            composable(route = PengelolaHalaman.Formulir.name) {
                HalamanDua(
                    options = DataSkripsi.namaDosenTI,
                    onSubmitButtonClicked = {
                        viewModel.setSkripsi(it)
                        navHostController.navigate(
                            PengelolaHalaman.Summary.name
                        )
                    },
                    onSelectionChangeSatu = { nameDosensatu ->
                        viewModel.setDospemsatu(nameDosensatu)
                    },
                    onSelectionChangeDua = { namaDosenDua ->
                        viewModel.setDospemdua(namaDosenDua)
                    }
                )
            }

            composable(route = PengelolaHalaman.Summary.name) {
                HalamanKetiga(
                    skripsiUiState = uiState,
                    onBackButtonClicked = {
                        navHostController.popBackStack(PengelolaHalaman.Formulir.name, false)
                    })
            }
        }
    }
}