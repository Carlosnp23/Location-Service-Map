package com.example.carlosnorambuena_mapd721_optionalassignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.carlosnorambuena_mapd721_optionalassignment.Model.Location
import com.example.carlosnorambuena_mapd721_optionalassignment.R

class LocationAdapter(private var locationList: List<Location>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>()  {

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImage: ImageView = itemView.findViewById(R.id.imgImage)
        val txtname: TextView = itemView.findViewById(R.id.txtName)
        val txtdesc: TextView = itemView.findViewById(R.id.txtDesc)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

        fun collapseExpandedView(){
            txtdesc.visibility = View.GONE
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

        val lcationData = locationList[position]
        holder.imgImage.setImageResource(lcationData.logo)
        holder.txtname.text = lcationData.title
        holder.txtdesc.text = lcationData.desc

        val isExpandable: Boolean = lcationData.isExpandable
        holder.txtdesc.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            lcationData.isExpandable = !lcationData.isExpandable
            notifyItemChanged(position , Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int){
        val temp = locationList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            locationList[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }

    override fun onBindViewHolder(
        holder: LocationViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

}