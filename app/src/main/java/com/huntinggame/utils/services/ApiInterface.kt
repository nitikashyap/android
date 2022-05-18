package com.huntinggame.utils.services

import com.huntinggame.utils.services.BaseUrlWithRequest.onProcess
import com.huntinggame.utils.Common.CommanModal
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import java.util.HashMap

interface ApiInterface   {
    @Multipart
    @POST(onProcess)
    fun onProcess(
        @Query("scope_x") scope_x: String,
        @Query("scope_y") scope_y: String,
        @Query("scope_radius") scope_radius: String,
        @Query("threshold") threshold: String, @Part profile_body: MultipartBody.Part) : Observable<CommanModal?>


}