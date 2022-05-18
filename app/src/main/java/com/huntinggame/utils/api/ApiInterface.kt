package com.huntinggame.utils.api



import com.huntinggame.utils.Common.CommanModal
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import okhttp3.MultipartBody

import okhttp3.RequestBody

import retrofit2.http.PartMap

import retrofit2.http.POST

import retrofit2.http.Multipart




interface ApiInterface {
    @Multipart
    @POST("process")
    fun onProgress(@Part("text") partMapData: Map<String,  RequestBody>, @Part profileImage: MultipartBody.Part): Response<CommanModal>


}