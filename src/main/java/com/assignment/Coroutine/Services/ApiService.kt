package com.assignment.Coroutine.Services

import com.assignment.Coroutine.Model.CountryDetails
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getData(@Url url: String): Deferred<CountryDetails>
}