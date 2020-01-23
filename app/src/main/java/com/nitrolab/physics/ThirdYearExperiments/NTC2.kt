package com.nitrolab.physics.ThirdYearExperiments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.EntryXComparator
import com.nitrolab.physics.Adapters.NTCAdapter
import com.nitrolab.physics.Models.NTCRecycleModel
import com.nitrolab.physics.R
import kotlinx.android.synthetic.main.activity_bondpass_chart.btn_getResults
import kotlinx.android.synthetic.main.activity_bondpass_chart.chart
import kotlinx.android.synthetic.main.activity_ntc2.*
import java.math.BigDecimal
import java.util.*
import kotlin.math.exp
import kotlin.math.ln


class NTC2 : AppCompatActivity() {

    private val entries = ArrayList<Entry>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ntc2)

        getResultsMethod()

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

    private fun getResultsMethod() {
        val dateModels = ArrayList<NTCRecycleModel>()
        btn_getResults.setOnClickListener {

            val tempC = ("0" + ed_tCelsius.text.toString() + ".0").toDouble()

            if (tempC in 25.0..100.0) {
                val tempK = tempC + 273.0
                val reverseKelvin = 1.0/tempK
                val power = (4387.0 / (273.0 + tempC)) - 10.909
                val resistance = exp(power)
                val logResistance = ln(resistance)

                val reverseKelvinFinal = BigDecimal(reverseKelvin).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                val resistanceFinal = BigDecimal(resistance).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                val logResistanceFinal = BigDecimal(logResistance).setScale(3, BigDecimal.ROUND_DOWN).toDouble()

                dateModels.add(NTCRecycleModel(tempC,tempK,reverseKelvinFinal,resistanceFinal,logResistanceFinal))

                val x = reverseKelvin.toFloat()
                val y = logResistance.toFloat()

                entries.add(Entry(x,y))

                txt_celsius.visibility = View.VISIBLE
                txt_kelvin.visibility = View.VISIBLE
                txt_reverseKelvin.visibility = View.VISIBLE
                txt_resistance.visibility = View.VISIBLE
                txt_logResistance.visibility = View.VISIBLE
                ed_tCelsius.setText("")
                dateModels.reverse()

                ntcRecycleView.layoutManager = LinearLayoutManager(this@NTC2)
                val adapter = NTCAdapter(dateModels)
                ntcRecycleView.adapter = adapter
                showGraph()

            } else {
                Toast.makeText(this@NTC2, "تأكد بأن القيمة بين 25 و 100", Toast.LENGTH_LONG).show()
            }
        }
    }

}
