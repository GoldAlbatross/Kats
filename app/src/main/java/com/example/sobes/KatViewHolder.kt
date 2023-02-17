package com.example.sobes

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sobes.okhttp.Cat


class KatViewHolder(parent: View): RecyclerView.ViewHolder(parent) {
    val image: ImageView = parent.findViewById(R.id.item)

    fun bind( cat: Cat) {
        Glide.with(itemView.context)
            .load(cat.url)
            .into(image)
    }

}