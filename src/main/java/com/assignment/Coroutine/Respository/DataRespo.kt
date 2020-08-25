package com.assignment.Coroutine.Respository

import com.assignment.Coroutine.Model.CountryDetails
import com.assignment.Coroutine.Services.ApiService

class DataRespo @javax.inject.Inject constructor(
    private val apiService: ApiService) {

    suspend fun getCountryDetails(fullUrl: String): CountryDetails {
        val job = apiService.getData(fullUrl)
        var countryDetails = job?.await()
        return countryDetails
    }
}
