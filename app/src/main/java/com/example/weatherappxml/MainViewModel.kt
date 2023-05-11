package com.example.weatherappxml

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Отображение текущей погоды
class MainViewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<String>()
    val liveDataList = MutableLiveData<List<String>>()
}