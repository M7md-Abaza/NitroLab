package com.nitrolab.physics.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nitrolab.physics.Models.HintBandPassRecycleFrequencyModel
import com.nitrolab.physics.R
import java.util.*

class HintBandPassRecycleFrequencyAdapter (var hintModels : ArrayList<HintBandPassRecycleFrequencyModel>)
    : RecyclerView.Adapter<HintBandPassRecycleFrequencyAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return MyHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val hintModel: HintBandPassRecycleFrequencyModel = hintModels[position]
        holder.value.text = hintModel.getHintValue().toString() + ""
    }


    override fun getItemCount(): Int {
        return hintModels.size
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        var value: TextView = itemView.findViewById(R.id.valueHintItem)

    }
}
