package com.example.sobes.okhttp

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("v1/images/search")
    fun getCats(): Call<List<ResponseCat>>
}


