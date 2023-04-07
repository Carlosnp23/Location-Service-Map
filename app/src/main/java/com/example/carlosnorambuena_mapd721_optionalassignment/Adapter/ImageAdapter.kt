package com.example.carlosnorambuena_mapd721_optionalassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places
import com.example.carlosnorambuena_mapd721_optionalassignment.R

class ImageAdapter(
    private val context: Context,
    private val images: List<Places>,
    private val listener: (Places) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.title.text = images[position].title
        holder.place.setImageResource(images[position].image)

        holder.bindView(images[position], listener)

    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val place: ImageView = view.findViewById(R.id.image_View)
        val title: TextView = view.findViewById(R.id.title_Text_View)
        fun bindView(image: Places, listener: (Places) -> Unit) {
            place.setImageResource(image.image)
            title.text = image.title
            itemView.setOnClickListener { listener(image) }
        }
    }
}