package com.example.dormintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel: ViewModel() {

    private val crimeRepository = CrimeRepository.get()

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "Init started")
        viewModelScope.launch {
            Log.d(TAG, "Coroutine started")
            crimes += loadCrimes()

            Log.d(TAG, "Finished adding crimes")
        }
    }
    suspend fun loadCrimes(): List<Crime> = crimeRepository.getCrimes()

}