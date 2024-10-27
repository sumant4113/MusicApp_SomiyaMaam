package com.example.musicapp_somiyamaam.interfaces

import android.telecom.Call
import com.example.musicapp_somiyamaam.model.MyMusicData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers(
        "x-rapidapi-key: e98e9a4834mshae594eb70258b97p175272jsnfa78fb6c60bb",
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query: String): retrofit2.Call<MyMusicData>

}