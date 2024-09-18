package com.example.mvvmmatematikislemi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(anaSayfaViewModel: AnaSayfaViewModel) {
    val tfSayi = remember { mutableStateOf("") }
    val sonuc by anaSayfaViewModel.sonuc.observeAsState(0L) // ViewModel'deki LiveData'yı gözlemleyelim

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Faktöriyel Hesaplama")}) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$sonuc", fontSize = 50.sp)

            TextField(
                value = tfSayi.value,
                onValueChange = { tfSayi.value = it },
                label = { Text(text = "Sayı Giriniz") }
            )

            Button(onClick = {
                anaSayfaViewModel.faktoriyelHesapla(tfSayi.value) // ViewModel'e kullanıcı girdisini gönder
            }) {
                Text(text = "Hesapla")
            }
        }
    }
}
