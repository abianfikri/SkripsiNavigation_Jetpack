package com.example.exercise2_jetpack.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise2_jetpack.R
import com.example.exercise2_jetpack.data.SkripsiUiState

@Composable
fun HalamanKetiga(
    skripsiUiState: SkripsiUiState,
    onBackButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = stringResource(id = R.string.nama))
        Text(text = skripsiUiState.nama)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.nim))
        Text(text = skripsiUiState.nim)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.konsentrasi))
        Text(text = skripsiUiState.konsentrasival)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.judul_skripsi))
        Text(text = skripsiUiState.judulSkripsi)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.dosenSatu))
        Text(text = skripsiUiState.dospemSatu)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.dosenDua))
        Text(text = skripsiUiState.dospemDua)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = onBackButtonClicked,
            modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        {
            Text(text = stringResource(id = R.string.btn_back))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview2() {
    HalamanKetiga(skripsiUiState = SkripsiUiState()) {}
}