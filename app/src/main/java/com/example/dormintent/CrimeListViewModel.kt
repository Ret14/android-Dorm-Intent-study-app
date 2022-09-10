package com.example.dormintent

import androidx.lifecycle.ViewModel

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel: ViewModel() {

    private val crimeRepository = CrimeRepository.get()

    val crimes = crimeRepository.getCrimes()

}