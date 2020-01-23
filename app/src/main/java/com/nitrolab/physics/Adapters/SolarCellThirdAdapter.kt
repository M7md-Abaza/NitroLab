package com.nitrolab.physics.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nitrolab.physics.Models.SolarCellThirdModel
import com.nitrolab.physics.R

class SolarCellThirdAdapter(private var DateModels: ArrayList<SolarCellThirdModel>) :
    RecyclerView.Adapter<SolarCellThirdAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.solar_cell_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return DateModels.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dateModels : SolarCellThirdModel =DateModels[position]
        holder.distance.text=dateModels.getDistance().toString()+""
        holder.distanceSquare.text=dateModels.getDistanceSquare().toString()+""
        holder.distanceReverse.text=dateModels.getReverseDistance().toString()+""
        holder.current.text=dateModels.getCurrent().toString()+""
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var distance: TextView = itemView.findViewById(R.id.item_distance)
        var distanceSquare: TextView = itemView.findViewById(R.id.item_distanceSquare)
        var distanceReverse: TextView = itemView.findViewById(R.id.item_reverseDistance)
        var current: TextView = itemView.findViewById(R.id.item_current)
    }

}