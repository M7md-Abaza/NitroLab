package com.nitrolab.physics.ThirdYearExperiments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nitrolab.physics.FourthYearExperiments.BondPassChart
import com.nitrolab.physics.R
import kotlinx.android.synthetic.main.activity_bondpass_experiment_hz.btn_nextPage
import kotlinx.android.synthetic.main.activity_ntc_1.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.*


class NTC1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ntc_1)


        temperatureCelsiusChanged()
        nextPageMethod()
    }

    private fun temperatureCelsiusChanged() {

        et_tCelsius.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val tCelsius = ("0" + et_tCelsius.text.toString() + ".0").toDouble()
                if (tCelsius in 25.0..100.0) {
                    val y = (4387.0 / (273.0 + tCelsius)) - 10.909
                    val resistance = exp(y)//3.81247651
                    val resistanceFinal = BigDecimal(resistance).setScale(3, BigDecimal.ROUND_DOWN).toDouble()
                    tv_ResistanceResult.text = resistanceFinal.toString()

                } else {
                    Toast.makeText(this@NTC1, "Invalid Number ", Toast.LENGTH_LONG).show()
                    tv_ResistanceResult.text = "Invalid No."
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun nextPageMethod() {
        btn_nextPage.setOnClickListener {
            val intent = Intent(this@NTC1, NTC2::class.java)
            startActivity(intent)
        }
    }
}
