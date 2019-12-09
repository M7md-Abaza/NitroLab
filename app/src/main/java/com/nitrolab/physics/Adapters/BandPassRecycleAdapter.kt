package com.nitrolab.physics.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nitrolab.physics.Models.BandPassRecycleModel
import com.nitrolab.physics.R
import java.util.*

class BandPassRecycleAdapter(private var dateModels: ArrayList<BandPassRecycleModel>) :
    RecyclerView.Adapter<BandPassRecycleAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dateModel: BandPassRecycleModel = dateModels[position]
        holder.frequency.text = dateModel.getFrequency().toString() + ""
        holder.voltag.text = dateModel.getVoltage().toString() + ""
        holder.gain.text = dateModel.getGain().toString() + ""
        holder.logFreq.text = dateModel.getLogFreq().toString() + ""
    }

    override fun getItemCount(): Int {
        return dateModels.size
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        var frequency: TextView = itemView.findViewById(R.id.item_Frequency)
        var voltag: TextView = itemView.findViewById(R.id.item_Voltage)
        var gain: TextView = itemView.findViewById(R.id.item_gain)
        var logFreq: TextView = itemView.findViewById(R.id.item_logFreq)
    }
}