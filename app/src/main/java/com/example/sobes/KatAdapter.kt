package com.example.sobes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sobes.okhttp.Cat

class KatAdapter: RecyclerView.Adapter<KatViewHolder>() {
    val list = ArrayList<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KatViewHolder {
        return KatViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.kat_item, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: KatViewHolder, position: Int) {
        holder.bind(list[position])
    }
}