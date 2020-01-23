package com.nitrolab.physics.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nitrolab.physics.Models.NTCRecycleModel
import com.nitrolab.physics.R

class NTCAdapter(private var DateModels: ArrayList<NTCRecycleModel>) :
    RecyclerView.Adapter<NTCAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.ntc_recycle_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return DateModels.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dateModels: NTCRecycleModel = DateModels[position]
        holder.celsius.text = dateModels.getCelsius().toString() + ""
        holder.kelvin.text = dateModels.getKelvin().toString() + ""
        holder.reverseKelvin.text = dateModels.getReverseKelvin().toString() + ""
        holder.resistance.text = dateModels.getResistance().toString() + ""
        holder.logResistance.text = dateModels.getLogResistance().toString() + ""
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var celsius: TextView = itemView.findViewById(R.id.item_celsius)
        var kelvin: TextView = itemView.findViewById(R.id.item_kelvin)
        var reverseKelvin: TextView = itemView.findViewById(R.id.item_reverseKelvin)
        var resistance: TextView = itemView.findViewById(R.id.item_resistance)
        var logResistance: TextView = itemView.findViewById(R.id.item_current)
    }
}