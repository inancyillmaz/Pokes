package com.pokes


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PokemonService {
    @GET("pokemon")
    fun listPost(@Query("limit") limit: Int,@Query("offset") offset: Int)
            : Call<List<Pokelist>>

}