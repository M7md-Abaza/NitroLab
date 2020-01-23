package com.nitrolab.physics.ThirdYearExperiments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.EntryXComparator
import com.nitrolab.physics.Adapters.TransistorPart2Adapter
import com.nitrolab.physics.Models.TransistorPart2Model
import com.nitrolab.physics.R
import kotlinx.android.synthetic.main.activity_transistor_part2.*
import kotlinx.android.synthetic.main.activity_transistor_part2.chart
import java.math.BigDecimal
import java.util.*

class TransistorPart2 : AppCompatActivity() {

    private val entries = ArrayList<Entry>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transistor_part2)

        baseCurrentChanged()
        getCollectorCurrentResult()

    }

    private fun baseCurrentChanged() {
        et_baseCurrent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (et_baseCurrent.length() != 0) {
                    val iB = ("0" + et_baseCurrent.text.toString()).toDouble()
                    val iC = ((12.72 * iB) - 0.344)
                    val icc = BigDecimal(iC).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                    tv_collectorCurrentResult.text = icc.toString()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun getCollectorCurrentResult() {
        val dateModels = ArrayList<TransistorPart2Model>()
        btn_getCollectorCurrentResult.setOnClickListener {
            if (et_baseCurrent.length() != 0) {
                val iB = ("0" + et_baseCurrent.text.toString()).toDouble()
                val iC = ((12.72 * iB) - 0.344)
                val x = iB.toFloat()
                val y = iC.toFloat()

                entries.add(Entry(x, y))

                val icc = BigDecimal(iC).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                dateModels.add(TransistorPart2Model(iB, icc))


                et_baseCurrent.setText("")
                tv_collectorCurrentResult.text = ""
                dateModels.reverse()

                transistor_2_RecycleView.layoutManager = LinearLayoutManager(this@TransistorPart2)
                val adapter = TransistorPart2Adapter(dateModels)
                transistor_2_RecycleView.adapter = adapter
                showGraph()
            } else {
                Toast.makeText(this@TransistorPart2, "Enter Value", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //ShowGraph() for display the Graph
    private fun showGraph() {
        val lineDataSet = LineDataSet(getData(), "Nitro Lab")
        // next line of code to rearrange data passed to x-Axis
        Collections.sort(entries, EntryXComparator())
        val lineDataSets = ArrayList<ILineDataSet>()
        lineDataSet.color = ContextCompat.getColor(this, R.color.colorPrimary)
        lineDataSet.valueTextColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        lineDataSets.add(lineDataSet)
        val data = LineData(lineDataSets)
        chart.data = data
        chart.animateX(100)
        chart.invalidate()
    }

    // getData which pass the points to Graph
    private fun getData(): ArrayList<Entry> {
        return entries
    }

}
