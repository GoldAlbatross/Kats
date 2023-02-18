package com.example.sobes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.RoundedCorner
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
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
    lateinit var img: ImageView

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
        setContentView(R.layout.image_box)
        img = findViewById(R.id.img_kitties)
        img.setOnClickListener { showCat() }

        catService.getCats().enqueue(object : Callback<List<Cat>>{
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if (response.code() == 200) {
                    val x = response.body()?.get(0)?.url.toString()
                    Glide.with(this@MainActivity)
                        .load(x)
                        .centerCrop()
                        .transform(RoundedCorners(60))
                        .into(img)
                }
            }
            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            } })
    }
    private fun showCat() {
        catService.getCats().enqueue(object : Callback<List<Cat>>{
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if (response.code() == 200) {
                    val x = response.body()?.get(0)?.url.toString()
                    Glide.with(this@MainActivity)
                        .load(x)
                        .centerCrop()
                        .transform(RoundedCorners(60))
                        .into(img)
                }
            }
            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            } })
    }
}