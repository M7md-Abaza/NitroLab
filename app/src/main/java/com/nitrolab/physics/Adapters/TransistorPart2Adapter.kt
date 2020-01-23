package com.nitrolab.physics.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nitrolab.physics.Models.TransistorPart2Model
import com.nitrolab.physics.R

class TransistorPart2Adapter(private var DateModels: ArrayList<TransistorPart2Model>) :
    RecyclerView.Adapter<TransistorPart2Adapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.transistor_part2_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return DateModels.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dateModels: TransistorPart2Model = DateModels[position]
        holder.baseCurrent.text = "IB: " + dateModels.getBaseCurrent().toString() + ""
        holder.collectorCurrent.text = "IC: " + dateModels.getCollectorCurrent().toString() + ""
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var baseCurrent: TextView = itemView.findViewById(R.id.item_baseCurrent)
        var collectorCurrent: TextView = itemView.findViewById(R.id.item_collectorCurrent)
    }

}