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
import com.nitrolab.physics.Adapters.SolarCellThirdAdapter
import com.nitrolab.physics.Models.SolarCellThirdModel
import com.nitrolab.physics.R
import kotlinx.android.synthetic.main.activity_solar_cell__third.*
import kotlinx.android.synthetic.main.activity_solar_cell__third.chart
import kotlinx.android.synthetic.main.activity_transistor_part2.*
import java.math.BigDecimal
import java.util.*

class SolarCellThird : AppCompatActivity() {

    private val entries = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_cell__third)

        distanceChanged()
        getCurrentResult()
    }

    private fun distanceChanged() {
        et_distance.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (et_distance.length() != 0) {
                    val distance = ("0" + et_distance.text.toString()).toDouble()
                    val iCurrent = 1.35 / (distance * distance)
                    val iCurrentFinal =
                        BigDecimal(iCurrent).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                    tv_CurrentResult.text = iCurrentFinal.toString()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun getCurrentResult() {
        val dateModels = ArrayList<SolarCellThirdModel>()
        btn_getCurrentResult.setOnClickListener {
            if (et_distance.length() != 0) {
                val distance = ("0" + et_distance.text.toString()).toDouble()
                val distanceSquare = (distance * distance)
                val iCurrent = 1.35 / distanceSquare
                val reverseDistanceSquare = 1.0 / distanceSquare

                val x = reverseDistanceSquare.toFloat()
                val y = iCurrent.toFloat()

                entries.add(Entry(x, y))

                val iCurrentFinal =
                    BigDecimal(iCurrent).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                val reverseDistanceSquareFinal =
                    BigDecimal(reverseDistanceSquare).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                val distanceSquareFinal =
                    BigDecimal(distanceSquare).setScale(3, BigDecimal.ROUND_DOWN).toDouble()

                dateModels.add(
                    SolarCellThirdModel(
                        distance,
                        distanceSquareFinal,
                        reverseDistanceSquareFinal,
                        iCurrentFinal
                    )
                )

                et_distance.setText("")
                tv_CurrentResult.text = ""

                dateModels.reverse()

                solarCellThird_RecycleView.layoutManager = LinearLayoutManager(this@SolarCellThird)
                val adapter = SolarCellThirdAdapter(dateModels)
                solarCellThird_RecycleView.adapter = adapter
                showGraph()
            } else {
                Toast.makeText(this@SolarCellThird, "Enter Value", Toast.LENGTH_SHORT).show()
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
