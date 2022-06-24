package org.d3if2095.hitungkurs.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if2095.hitungkurs.model.Kurs
import org.d3if2095.hitungkurs.network.ApiStatus
import org.d3if2095.hitungkurs.network.KursApi

class MainViewModel : ViewModel() {

    private val data = MutableLiveData<List<Kurs>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(KursApi.service.getKurs())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Kurs>> = data

    fun getStatus(): LiveData<ApiStatus> = status
}