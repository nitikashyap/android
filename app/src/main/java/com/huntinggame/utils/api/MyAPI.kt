package com.huntinggame.utils.api

import com.huntinggame.utils.Common.CommanModal
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyAPI {

    @FormUrlEncoded
    @POST("process")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Field("scope_x") scope_x: String,
        @Field("scope_y") scope_y: String,
        @Field("scope_radius") scope_radius: String,
        @Field("threshold") threshold: String,
        @Field("file") file: String,
    ): Call<CommanModal>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .baseUrl("http://54.196.67.203/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
}