package com.example.dz3.datalayer

import android.util.Log
import com.example.dz3.objects.Friend
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IAccessor {
    @GET("/v2/beers")
    suspend fun getFriends(@Query("abv_lt") limit: Int): List<Friend>
    @GET("/v2/beers/{id}")
    suspend fun getFriend( @Path("id") id:String): List<Friend>

    companion object {
        fun create(): IAccessor {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }


            val client = OkHttpClient.Builder().apply {
                addNetworkInterceptor(loggingInterceptor)
            }.build()


            val retrofit = Retrofit.Builder().apply {
                client(client)
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://api.punkapi.com")
            }.build()


            return retrofit.create(IAccessor::class.java)
        }
    }
}