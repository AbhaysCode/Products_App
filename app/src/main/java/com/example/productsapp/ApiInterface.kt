package com.example.productsapp


import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getMyData(): Call<MyData>
}