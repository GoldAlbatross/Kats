package com.example.sobes

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class KatViewHolder(parent: View): RecyclerView.ViewHolder(parent) {
    val text: TextView = parent.findViewById(R.id.item)

    fun bind(kat: Kat) {
        text.text = kat.name
    }

}