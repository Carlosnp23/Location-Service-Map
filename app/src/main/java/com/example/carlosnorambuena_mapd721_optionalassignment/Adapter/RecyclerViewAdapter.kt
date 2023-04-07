package com.example.carlosnorambuena_mapd721_optionalassignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.MainActivity
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Places
import com.example.carlosnorambuena_mapd721_optionalassignment.R

class RecyclerViewAdapter constructor(
    private val getActivity: MainActivity,
    private val placeList: List<Places>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.placeTitle.text = placeList[position].title
        holder.placeImg.setImageResource(placeList[position].image)

        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity, placeList[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeTitle: TextView = itemView.findViewById(R.id.title_Text_View)
        val placeImg: ImageView = itemView.findViewById(R.id.image_View)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

}