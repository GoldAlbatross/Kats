package com.example.sobes

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("v1/images/search")
    fun getCats(): Call<ResponseCats>
}

class ResponseCats (val cats: CatData)
