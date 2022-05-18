package com.huntinggame.utils.Common

import androidx.lifecycle.ViewModel
import com.huntinggame.utils.services.BaseUrlWithRequest
import com.huntinggame.utils.services.ApiInterface

abstract class BaseViewModel : ViewModel(){


    val apiInterface : ApiInterface by lazy { ApiClient.getApiClient(BaseUrlWithRequest.BASE_URL) }
    // val apiGoogleInterface : ApiInterface by lazy { ApiClient.getApiClient(ParamEnum.GOOGLE_MAP_BASE_URL.theValue() as String) }
}