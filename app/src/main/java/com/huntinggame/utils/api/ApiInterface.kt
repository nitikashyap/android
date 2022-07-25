package com.huntinggame.utils.api



import com.huntinggame.Modal.Login
import com.huntinggame.utils.Common.CommanModal
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {
    @Multipart
    @POST("process")
    fun onProgress(@Part("text") partMapData: Map<String,  RequestBody>, @Part profileImage: MultipartBody.Part): Response<CommanModal>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("emailId") emailId: String?,
        @Field("password") password: String?
    ): Call<Login>?

}