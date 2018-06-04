package com.example.sdie3.testapp

import retrofit2.Call
import retrofit2.http.*
import java.security.cert.PKIXCertPathValidatorResult

/**
 * Created by sdie3 on 2018-06-04.
 */
data class ResponseDTO(var result:String? = null)

interface server_service {
    @GET("/get")
    fun getRequest(@Query("name") name: String): Call<ResponseDTO>
    //FormData
    //UrlEncoded
    //@FormUrlEncoded
    @GET("/get/{id}")
    fun getParamRequest(@Path("id")id : String): Call<ResponseDTO>

    @POST("/post")
    fun postRequest(): Call<ResponseDTO>
}