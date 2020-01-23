package com.nitrolab.physics.FourthYearExperiments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nitrolab.physics.Adapters.BandPassRecycleAdapter
import com.nitrolab.physics.Adapters.HintBandPassRecycleFrequencyAdapter
import com.nitrolab.physics.Models.BandPassRecycleModel
import com.nitrolab.physics.Models.HintBandPassRecycleFrequencyModel
import com.nitrolab.physics.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_bondpass_chart.*
import java.util.*
import kotlin.math.log10

class BondPassChart : AppCompatActivity() {

    private val entries = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bondpass_chart)

        //valueHintMethod() for display Frequency values in RecycleHint which user can be use
        valueHintMethod()
        //getResultsMethod() for display the Values like voltage according to Frequency values above
        getResultsMethod()

    }

    //ShowGraph() for display the Graph
    private fun showGraph() {
        val lineDataSet = LineDataSet(getData(), "Nitro Lab")
        val lineDataSets = ArrayList<ILineDataSet>()
        lineDataSet.color = ContextCompat.getColor(this, R.color.colorPrimary)
        lineDataSet.valueTextColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        lineDataSets.add(lineDataSet)
        val data = LineData(lineDataSets)
        chart.data = data
        chart.animateX(1000)
        chart.invalidate()
    }

    // getData which pass the points to Graph
    private fun getData(): ArrayList<Entry> {
        return entries
    }

    private fun getResultsMethod() {
        val dateModels = ArrayList<BandPassRecycleModel>()
        btn_getResults.setOnClickListener {
            val freq = "0" + ed_Frequency.text.toString()
            when (val iFreq = freq.toInt()) {
                in 1..10 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                20 -> {
                    val volt = 0.006
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                30 -> {
                    val volt = 0.0132
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                40 -> {
                    val volt = 0.021
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                50 -> {
                    val volt = 0.0282
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                60 -> {
                    val volt = 0.0366
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                70 -> {
                    val volt = 0.0444
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                80 -> {
                    val volt = 0.051
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                90 -> {
                    val volt = 0.06
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                100 -> {
                    val volt = 0.072
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                200 -> {
                    val volt = 0.132
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                300 -> {
                    val volt = 0.1704
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                400 -> {
                    val volt = 0.01992
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                500 -> {
                    val volt = 0.2232
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                600 -> {
                    val volt = 0.2406
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                700 -> {
                    val volt = 0.258
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                800 -> {
                    val volt = 0.2718
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                900 -> {
                    val volt = 0.282
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                1000 -> {
                    val volt = 0.288
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                2000 -> {
                    val volt = 0.225
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                3000 -> {
                    val volt = 0.1818
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                4000 -> {
                    val volt = 0.153
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                5000 -> {
                    val volt = 0.1326
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                6000 -> {
                    val volt = 0.1176
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                7000 -> {
                    val volt = 0.105
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                8000 -> {
                    val volt = 0.093
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                9000 -> {
                    val volt = 0.0828
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                10000 -> {
                    val volt = 0.0714
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                20000 -> {
                    val volt = 0.0294
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                30000 -> {
                    val volt = 0.0174
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                40000 -> {
                    val volt = 0.0105
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                50000 -> {
                    val volt = 0.0069
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                60000 -> {
                    val volt = 0.00438
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                70000 -> {
                    val volt = 0.0028
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                80000 -> {
                    val volt = 0.00169
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                90000 -> {
                    val volt = 0.00072
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                100000 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                200000 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                300000 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                400000 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                500000 -> {
                    val volt = 0.0
                    val gain = volt / 0.6
                    val logFreq = log10(iFreq.toDouble())
                    dateModels.add(BandPassRecycleModel(iFreq, volt, gain, logFreq))
                    val x = logFreq.toString().toFloat()
                    val y = gain.toString().toFloat()
                    entries.add(Entry(x, y))
                }
                else -> {
                    Toast.makeText(this@BondPassChart, "القيمة غير صحيحة", Toast.LENGTH_LONG).show()
                    dateModels.reverse()
                }
            }
            txtFreq.visibility = View.VISIBLE
            txtVolt.visibility = View.VISIBLE
            txtGain.visibility = View.VISIBLE
            txtLog.visibility = View.VISIBLE
            ed_Frequency.setText("")
            dateModels.reverse()

            recycle_view.layoutManager = LinearLayoutManager(this@BondPassChart)
            val adapter = BandPassRecycleAdapter(dateModels)
            recycle_view.adapter = adapter
            showGraph()
        }
    }

    private fun valueHintMethod() {
        val valueHint = ArrayList<HintBandPassRecycleFrequencyModel>()

        valueHint.add(HintBandPassRecycleFrequencyModel(1))
        valueHint.add(HintBandPassRecycleFrequencyModel(2))
        valueHint.add(HintBandPassRecycleFrequencyModel(3))
        valueHint.add(HintBandPassRecycleFrequencyModel(4))
        valueHint.add(HintBandPassRecycleFrequencyModel(5))
        valueHint.add(HintBandPassRecycleFrequencyModel(6))
        valueHint.add(HintBandPassRecycleFrequencyModel(7))
        valueHint.add(HintBandPassRecycleFrequencyModel(8))
        valueHint.add(HintBandPassRecycleFrequencyModel(9))
        valueHint.add(HintBandPassRecycleFrequencyModel(10))
        valueHint.add(HintBandPassRecycleFrequencyModel(20))
        valueHint.add(HintBandPassRecycleFrequencyModel(30))
        valueHint.add(HintBandPassRecycleFrequencyModel(40))
        valueHint.add(HintBandPassRecycleFrequencyModel(50))
        valueHint.add(HintBandPassRecycleFrequencyModel(60))
        valueHint.add(HintBandPassRecycleFrequencyModel(70))
        valueHint.add(HintBandPassRecycleFrequencyModel(80))
        valueHint.add(HintBandPassRecycleFrequencyModel(90))
        valueHint.add(HintBandPassRecycleFrequencyModel(100))
        valueHint.add(HintBandPassRecycleFrequencyModel(200))
        valueHint.add(HintBandPassRecycleFrequencyModel(300))
        valueHint.add(HintBandPassRecycleFrequencyModel(400))
        valueHint.add(HintBandPassRecycleFrequencyModel(500))
        valueHint.add(HintBandPassRecycleFrequencyModel(600))
        valueHint.add(HintBandPassRecycleFrequencyModel(800))
        valueHint.add(HintBandPassRecycleFrequencyModel(900))
        valueHint.add(HintBandPassRecycleFrequencyModel(1000))
        valueHint.add(HintBandPassRecycleFrequencyModel(2000))
        valueHint.add(HintBandPassRecycleFrequencyModel(3000))
        valueHint.add(HintBandPassRecycleFrequencyModel(4000))
        valueHint.add(HintBandPassRecycleFrequencyModel(5000))
        valueHint.add(HintBandPassRecycleFrequencyModel(6000))
        valueHint.add(HintBandPassRecycleFrequencyModel(7000))
        valueHint.add(HintBandPassRecycleFrequencyModel(8000))
        valueHint.add(HintBandPassRecycleFrequencyModel(9000))
        valueHint.add(HintBandPassRecycleFrequencyModel(10000))
        valueHint.add(HintBandPassRecycleFrequencyModel(20000))
        valueHint.add(HintBandPassRecycleFrequencyModel(30000))
        valueHint.add(HintBandPassRecycleFrequencyModel(40000))
        valueHint.add(HintBandPassRecycleFrequencyModel(50000))
        valueHint.add(HintBandPassRecycleFrequencyModel(60000))
        valueHint.add(HintBandPassRecycleFrequencyModel(70000))
        valueHint.add(HintBandPassRecycleFrequencyModel(80000))
        valueHint.add(HintBandPassRecycleFrequencyModel(90000))
        valueHint.add(HintBandPassRecycleFrequencyModel(100000))
        valueHint.add(HintBandPassRecycleFrequencyModel(200000))
        valueHint.add(HintBandPassRecycleFrequencyModel(300000))
        valueHint.add(HintBandPassRecycleFrequencyModel(400000))
        valueHint.add(HintBandPassRecycleFrequencyModel(500000))

        listHint.layoutManager = LinearLayoutManager(this@BondPassChart, LinearLayoutManager.HORIZONTAL, false)
        val adapter = HintBandPassRecycleFrequencyAdapter(valueHint)
        listHint.adapter = adapter
    }
}
