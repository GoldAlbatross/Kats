package com.example.sobes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sobes.okhttp.Cat

class KatAdapter(private val clickListener: NewCat): RecyclerView.Adapter<KatViewHolder>() {
    var urls = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KatViewHolder {
        return KatViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.kat_item, parent, false))
    }
    override fun getItemCount(): Int = urls.size
    override fun onBindViewHolder(holder: KatViewHolder, position: Int) {
        holder.bind(urls[position])
        holder.itemView.setOnClickListener {clickListener.onImageClick(urls[position])}
    }
    fun interface NewCat { fun onImageClick(item: String) }
}

class KatViewHolder(parent: View): RecyclerView.ViewHolder(parent) {
    val image: ImageView = parent.findViewById(R.id.item)

    fun bind( url: String) {
        Glide.with(itemView.context)
            .load(url)
            .centerCrop()
            .into(image)
    }
}