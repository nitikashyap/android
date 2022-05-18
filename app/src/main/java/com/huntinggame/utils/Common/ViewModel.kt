package com.huntinggame.utils.Common

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.util.HashMap

class ViewModel :BaseViewModel() {
    var error = MutableLiveData<Throwable>()
    var response = MutableLiveData<CommanModal?>()

    @SuppressLint("CheckResult")
    fun onProcess(context: Context, params: HashMap<String, Any>, profile_body: MultipartBody.Part) {
        CustomLoader.showLoader(context as Activity)

        apiInterface.onProcess(params.get("scope_x").toString(),params.get("scope_y").toString(),params.get("scope_radius").toString(),params.get("threshold").toString(),profile_body).subscribeOn(
            Schedulers.io()
        ).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe(
            {
                CustomLoader.hideLoader()
                this.response.value = it
            },
            {

                Log.d(TAG, "onProcess error: $error")
                CustomLoader.hideLoader()
                error.value = it
            })
    }

}