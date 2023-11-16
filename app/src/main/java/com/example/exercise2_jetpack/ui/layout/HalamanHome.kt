package com.example.exercise2_jetpack.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise2_jetpack.R
import com.example.exercise2_jetpack.ui.theme.Exercise2_JetpackTheme

@Composable
fun HalamanSatu(
    onNextButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.umy),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onNextButtonClicked) {
            Text(text = stringResource(id = R.string.btn_next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showPreviewHome() {
    Exercise2_JetpackTheme {
        HalamanSatu(){}
    }
}