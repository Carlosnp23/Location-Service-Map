package com.example.carlosnorambuena_mapd721_optionalassignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Location
import com.example.carlosnorambuena_mapd721_optionalassignment.R

class LocationAdapter(private var locationList: List<Location>, val listener: MyClickListener) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>()  {

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImage: ImageView = itemView.findViewById(R.id.imgImage)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtDesc: TextView = itemView.findViewById(R.id.txtDesc)


        init {
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                listener.onClick(position)
            }
        }


    }

    fun setFilteredList(mList: List<Location>) {
        this.locationList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {

        val locationData = locationList[position]
        holder.imgImage.setImageResource(locationData.logo)
        holder.txtName.text = locationData.title
        holder.txtDesc.text = locationData.desc

    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }

}