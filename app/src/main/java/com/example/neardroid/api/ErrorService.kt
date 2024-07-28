package com.example.neardroid.api

import android.app.Activity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.HttpException
import java.io.Reader
import java.net.HttpURLConnection

class ErrorService(
    private val activity: Activity? = null,
    private val gson: Gson? = null,
) {
    interface ExceptionHandler {
        fun supportHttpCode(code: Int): Boolean
        fun handle(e: Throwable?)
    }

    fun handleException(throwable: Throwable?, vararg handlers: ExceptionHandler) {
        var throwable = throwable
        var httpCode = 0
        if (throwable is HttpException) {
            httpCode = throwable.code()
        }
        val serverErrorException = parseErrorService(throwable)
        if (serverErrorException != null) {
            throwable = serverErrorException
        }
        var isHandle = false
        for (handler in handlers) {
            if (handler.supportHttpCode(httpCode)) {
                Log.d("API_ERROR", "User custom HttpExceptionHandler to handle HttpException code: $httpCode")
                isHandle = true
                handler.handle(throwable)
            }
        }
        if (!isHandle) {
            defaultHandleException(httpCode, throwable)
        }
    }

    protected fun defaultHandleException(httpCode: Int, throwable: Throwable?) {
        if (httpCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
//            unSubscribeFirebase()
//            mrtrRepository.deleteAllCache()
//                .onErrorResumeNext { t: Throwable? ->
//                    Log.e(TAG, "Exception on delete session", t)
//                    Observable.just(true)
//                }
//                .doOnComplete {
//                    showDialog(activity.getString(R.string.error_message_authorization), callbackDialog() , throwable)
//                }
//                .subscribe(
//                    { b: Boolean? -> }
//                ) { exception: Throwable? -> }
        } else {
//            val isNotAllowTransaction = httpCode == 403
//            if (isNotAllowTransaction) {
//                showDialog(getErrorMessage(throwable), killActivity(), throwable)
//            } else {
//                showErrorDialog(getErrorMessage(throwable), throwable)
//            }
        }
    }

    private fun parseErrorService(throwable: Throwable?): ServerErrorException? {
        if (throwable is HttpException) {
            val response = throwable.response()
            val errorBody = response?.errorBody()
            val error = parseJsonErrorService(throwable.code(), errorBody?.charStream())
            if (error != null) return error
        }
        return null
    }

    private fun parseJsonErrorService(code: Int, jsonError: Reader?): ServerErrorException? {
        try {
            val jsonNode = gson?.fromJson(
                jsonError,
                JsonObject::class.java
            )
            if (jsonNode != null) {
                return getServerErrorException(code, jsonNode)
            }
        } catch (e: Exception) {
            Log.e("API_ERROR", "Cannot convert JSON to ErrorCollection", e)
        }
        return null
    }

    private fun getServerErrorException(code: Int, jsonNode: JsonObject): ServerErrorException {
        val jsonDesc = "desc"
        val jsonMessage = "message"
        val jsonResponseDateTime = "responseDateTime"
        val jsonSystemMessage = "systemMessage"
        val jsonCodeType = "codeType"
        val jsonCode = "code"
        var desc: String? = ""
        if (jsonNode.has(jsonDesc) && !jsonNode[jsonDesc].asString.isEmpty()) {
            desc = jsonNode[jsonDesc].asString
        } else if (jsonNode.has(jsonMessage)) {
            desc = jsonNode[jsonMessage].asString
        }
        var responseDateTime: String? = ""
        if (jsonNode.has(jsonResponseDateTime)) {
            responseDateTime = jsonNode[jsonResponseDateTime].asString
        }
        var systemMessage: String? = ""
        if (jsonNode.has(jsonSystemMessage)) {
            systemMessage = jsonNode[jsonSystemMessage].asString
        }
        var codeType: String? = ""
        if (jsonNode.has(jsonCodeType)) {
            codeType = jsonNode[jsonCodeType].asString
        }
        var errorCode: String? = ""
        if (jsonNode.has(jsonCode)) {
            errorCode = jsonNode[jsonCode].asString
        }
        val error = ErrorCollection()
        error.statusCode = errorCode
        error.description = desc
        error.responseDateTime = responseDateTime
        error.systemMessage = systemMessage
        error.codeType = codeType
//        error.username = mrtrRepository.sessionNow.retailerNumber
        return ServerErrorException(code, error)
    }
}