package com.pokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pokes.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


lateinit var postService: PokemonService
lateinit var List: List<Pokelist>


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postService = RetrofitClient.getClient().create(PokemonService::class.java)
        var post = postService.listPost(30,30);

        post.enqueue(object : Callback<List<Pokelist>> {
            override fun onFailure(call: Call<List<Pokelist>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
                Log.e("onFailure: " , t.toString(), )
            }

            override fun onResponse(
                call: Call<List<Pokelist>>,
                response: Response<List<Pokelist>>
            ) {

                Log.d("Deneme",response.toString())

                if (response.isSuccessful) {
                    List = (response.body() as List<Pokelist>?)!!
                    Log.d("Deneme", List.toString())
                }
            }
        })


    }
}