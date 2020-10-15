package com.pokes.Retrofit

import com.pokes.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{
    companion object{
        fun getClient():Retrofit{
            return Retrofit.Builder().
            baseUrl(Constant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}