package com.example.sobes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var list: MutableList<Kat>
    lateinit var recyler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = mutableListOf(Kat("Kuzya"), Kat("Vasya"),Kat("Olya"))
        recyler = findViewById(R.id.recycler)
        recyler.adapter = KatAdapter(list)
        recyler.layoutManager = LinearLayoutManager(this)
    }
}