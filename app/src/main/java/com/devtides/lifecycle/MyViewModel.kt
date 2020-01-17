package com.devtides.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val valor = MutableLiveData<Int>()

    fun getValor(): LiveData<Int> = valor

    fun random() {
        this.valor.value = (1..100).shuffled().last()
    }
}