package com.example.sobes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sobes.okhttp.Cat
import com.example.sobes.okhttp.CatApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyler: RecyclerView
    var catAdapter = KatAdapter()

    private val baseUrl = "https://api.thecatapi.com/"
    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    val x = OkHttpClient.Builder().addInterceptor(logging).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(x)
        .build()
    private val catService = retrofit.create(CatApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyler = findViewById(R.id.recycler)
        recyler.layoutManager = LinearLayoutManager(this)

    catService.getCats().enqueue(object : Callback<List<Cat>>{

    override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
        if (response.code() == 200) {
            catAdapter.urls.add(response.body()?.get(0)?.url.toString())
            recyler.adapter = catAdapter
            recyler.adapter?.notifyDataSetChanged()
        }
    }

    override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
    }

})

    }
}