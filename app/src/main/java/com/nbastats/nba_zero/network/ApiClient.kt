package com.nbastats.nba_zero.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        val base_url = "https://nba-player-individual-stats.p.rapidapi.com/"

        fun getHttpClient(): OkHttpClient {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
        }


        fun RetrofitInstance(): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build()
        }


    }
}