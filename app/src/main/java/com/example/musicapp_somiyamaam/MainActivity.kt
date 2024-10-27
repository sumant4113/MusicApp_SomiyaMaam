package com.example.musicapp_somiyamaam

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp_somiyamaam.R.id.txt_hello
import com.example.musicapp_somiyamaam.R.layout.activity_main
import com.example.musicapp_somiyamaam.interfaces.ApiInterface
import com.example.musicapp_somiyamaam.model.MyMusicData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_main)

        val txtHello = findViewById<TextView>(txt_hello)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyMusicData?> {
            override fun onResponse(call: Call<MyMusicData?>, response: Response<MyMusicData?>) {

                val dataList = response.body()?.data
                txtHello.text = dataList.toString()
                Log.d(TAG, "onResponse: +-+-"+response.body())

            }
            override fun onFailure(call: Call<MyMusicData?>, t: Throwable) {
                Log.d(TAG, "onFailure: +-+-" + t.message)
            }
        })

    }
}