package com.junadhi.superheroapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter (
    private val context: Context,
    private val images: List<Superhero>,
    val listener: (Superhero) -> Unit
    ) : RecyclerView.Adapter<SuperheroAdapter.ImageViewHolder>() {
        class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageSrc = view.findViewById<ImageView>(R.id.img_item_photo)
            val title = view.findViewById<TextView>(R.id.tv_item_name)
            fun bindView(image: Superhero, listener: (Superhero) -> Unit) {
                imageSrc.setImageResource(image.imageSrc)
                title.text = image.imageTitle
                itemView.setOnClickListener { listener(image) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
            ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_superhero, parent, false))

        override fun getItemCount(): Int = images.size

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            holder.bindView(images[position], listener)
        }
    }