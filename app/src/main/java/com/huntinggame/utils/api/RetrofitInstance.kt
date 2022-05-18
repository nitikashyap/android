package com.dacorpindia.bhadaexpress.driverapp.services

import com.google.gson.GsonBuilder
import com.huntinggame.utils.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {
    private val API_BASE_URL = "http://54.196.67.203/"

    private var retrofit: Retrofit? = null
    private var gson = GsonBuilder().setLenient().create()

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS).addInterceptor(interceptor).build()

    private fun getloginClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        return retrofit
    }


    val instence: ApiInterface? = getloginClient()?.create(ApiInterface::class.java)
}