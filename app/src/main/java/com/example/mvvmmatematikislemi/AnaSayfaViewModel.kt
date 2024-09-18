package com.example.mvvmmatematikislemi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnaSayfaViewModel : ViewModel() {

    private val _sonuc = MutableLiveData<Long>()
    val sonuc: LiveData<Long> = _sonuc

    fun faktoriyelHesapla(alinanSayi: String) {
        val sayi = alinanSayi.toIntOrNull()
        if (sayi != null && sayi >= 0) {
            _sonuc.value = faktoriyelHesapla(sayi)
        } else {
            _sonuc.value = 0L // Geçersiz sayı girildiğinde sıfır göster
        }
    }

    private fun faktoriyelHesapla(sayi: Int): Long {
        var sonuc = 1L
        for (i in 1..sayi) {
            sonuc *= i
        }
        return sonuc
    }
}

