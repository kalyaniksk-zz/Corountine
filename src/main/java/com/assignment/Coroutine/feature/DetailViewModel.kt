package com.assignment.Coroutine.feature

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.Coroutine.Common.Constant
import com.assignment.Coroutine.Generic.ErrorResponse
import com.assignment.Coroutine.Generic.Response
import com.assignment.Coroutine.Generic.SuccessResponse
import com.assignment.Coroutine.Model.CountryDetails
import com.assignment.Coroutine.Model.Rows
import com.assignment.Coroutine.Respository.DataRespo
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class DetailViewModel @Inject constructor(private val respo: DataRespo) : ViewModel() {

    private val countryDetailsMutableData = MutableLiveData<Response<CountryDetails, Throwable>>()
    fun getCountryDetailsObservable(): LiveData<Response<CountryDetails, Throwable>> {
        return countryDetailsMutableData
    }

    init {
        getDetails()
    }
    private fun getDetails(){
        viewModelScope.launch {
            try {
                countryDetailsMutableData.value = SuccessResponse(respo.getCountryDetails(fullUrl = Constant.COUNTRY_DETAILS_URL))
            } catch (throwable: Throwable) {
                countryDetailsMutableData.value = ErrorResponse(throwable)
            }
        }
    }

}