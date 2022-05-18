package com.huntinggame.utils.Common

import android.content.Context
import android.content.Intent
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorUtil {
    fun handlerGeneralError(context: Context?, throwable: Throwable) {
        throwable.printStackTrace()
        if (context == null) return

        when (throwable) {
            is ConnectException -> showSnackBar(context,"Connection lost")
            is SocketTimeoutException -> showSnackBar(context,"Socket Time Out Exception")
            is UnknownHostException -> showSnackBar(context,"No Internet Connection")
            is InternalError -> showSnackBar(context,"Internal Server Error")
            is HttpException -> {
                try {
                    when (throwable.code()) {
                        401 -> {
                            forceLogout(context)
                        }
                        403 -> {
                            displayError(context, throwable)
                        } 500->{
                        forceLogout(context)

                    }
                        else -> {
                            displayError(context, throwable)
                        }
                    }
                } catch (exception: Exception) {
                     showSnackBar(context,"Something went wrong")

                }
            } else -> {
             showSnackBar(context,"Something went wrong")

        }
        }
    }

    private fun displayError(context: Context, throwable: HttpException) {

    }

    private fun showSnackBar(context: Context, mesage: String) {
        //Toaster.toast(mesage)
    }

    fun forceLogout(context: Context) {

//        var intent= Intent(context, ActivityTakeAToarSecound::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//        context.startActivity(intent)


    }

}