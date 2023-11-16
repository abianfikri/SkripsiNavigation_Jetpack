package com.example.exercise2_jetpack.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise2_jetpack.R
import com.example.exercise2_jetpack.ui.theme.Exercise2_JetpackTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDua(
    options: List<String>,
    onSelectionChangeSatu: (String) -> Unit = {},
    onSelectionChangeDua: (String) -> Unit = {},
    onSubmitButtonClicked: (MutableList<String>) -> Unit,

    ) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }

    var nimTxt by rememberSaveable {
        mutableStateOf("")
    }

    var konsentrasuTxt by rememberSaveable {
        mutableStateOf("")
    }

    var judulTxt by remember {
        mutableStateOf("")
    }

    var selectedValueSatu by remember {
        mutableStateOf("")
    }

    var selectedValueDua by remember {
        mutableStateOf("")
    }

    var lisData: MutableList<String> = mutableListOf(namaTxt, nimTxt, konsentrasuTxt, judulTxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp)
        )

        OutlinedTextField(
            value = namaTxt,
            onValueChange = { namaTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nama
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = nimTxt,
            onValueChange = { nimTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nim
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = konsentrasuTxt,
            onValueChange = { konsentrasuTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.konsentrasi
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = judulTxt,
            onValueChange = { judulTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.judul_skripsi
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(text = stringResource(id = R.string.dosenSatu))
                options.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =Modifier.selectable(
                            selected = selectedValueSatu == item,
                            onClick ={
                                selectedValueSatu = item
                                onSelectionChangeSatu(item)
                            }
                        )
                    ) {
                        RadioButton(
                            selected = selectedValueSatu == item,
                            onClick = {
                                selectedValueSatu = item
                                onSelectionChangeSatu(item)
                            }
                        )
                        Text(item)
                    }
                }
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column {
                Text(text = stringResource(id = R.string.dosenDua))
                options.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =Modifier.selectable(
                            selected = selectedValueSatu == item,
                            onClick ={
                                selectedValueSatu = item
                                onSelectionChangeSatu(item)
                            }
                        )
                    ) {
                        RadioButton(
                            selected = selectedValueDua == item,
                            onClick = {
                                selectedValueDua = item
                                onSelectionChangeDua(item)
                            }
                        )
                        Text(item)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { onSubmitButtonClicked(lisData) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = stringResource(id = R.string.btn_submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showPreview2() {
    Exercise2_JetpackTheme {
        HalamanDua(options = listOf(
            "Haris Setiawan",
            "Dwi Djoko P",
            "Aprilia Kurnianti"
        )){}
    }
}