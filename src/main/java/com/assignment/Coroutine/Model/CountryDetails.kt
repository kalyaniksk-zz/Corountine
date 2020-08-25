package com.assignment.Coroutine.Model

import com.squareup.moshi.Json

data class CountryDetails(
    @Json(name = "title")
    var title : String,
    @Json(name = "rows")
    var rows : List<Rows>

)


data class Rows(
    @Json(name= "title")
    var title : String,
    @Json(name= "description")
    var description: String
)