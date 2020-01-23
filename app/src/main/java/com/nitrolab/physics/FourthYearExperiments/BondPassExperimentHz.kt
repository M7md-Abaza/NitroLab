package com.nitrolab.physics.FourthYearExperiments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nitrolab.physics.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_bondpass_experiment_hz.*

class BondPassExperimentHz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bondpass_experiment_hz)

        frequencyChange()
        nextPageMethod()
        adsBanner()
    }

    private fun adsBanner() {
        MobileAds.initialize(this) { }
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        val adView = AdView(this)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-4454440016331822/2911405460"
        // for test: ca-app-pub-3940256099942544/6300978111
    }

    private fun frequencyChange() {
        Frequency.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                when (val result = ("0" + Frequency.text.toString().trim { it <= ' ' }).toInt()) {
                    in 20..100000 -> {
                        when (result) {
                            20 -> volt.text = "0.006"
                            30 -> volt.text = "0.0132"
                            40 -> volt.text = "0.021"
                            50 -> volt.text = "0.0282"
                            60 -> volt.text = "0.0366"
                            70 -> volt.text = "0.0444"
                            80 -> volt.text = "0.051"
                            90 -> volt.text = "0.06"
                            100 -> volt.text = "0.072"
                            110 -> volt.text = "0.0816"
                            120 -> volt.text = "0.0888"
                            130 -> volt.text = "0.0948"
                            140 -> volt.text = "0.1014"
                            150 -> volt.text = "0.1092"
                            160 -> volt.text = "0.1131"
                            170 -> volt.text = "0.1182"
                            180 -> volt.text = "0.1218"
                            190 -> volt.text = "0.1254"
                            200 -> volt.text = "0.132"
                            210 -> volt.text = "0.1356"
                            220 -> volt.text = "0.141"
                            230 -> volt.text = "0.144"
                            240 -> volt.text = "0.1488"
                            250 -> volt.text = "0.153"
                            260 -> volt.text = "0.1554"
                            270 -> volt.text = "0.1596"
                            280 -> volt.text = "0.1626"
                            290 -> volt.text = "0.1662"
                            300 -> volt.text = "0.1704"
                            310 -> volt.text = "0.1722"
                            320 -> volt.text = "0.1746"
                            330 -> volt.text = "0.1794"
                            340 -> volt.text = "0.1818"
                            350 -> volt.text = "0.1848"
                            360 -> volt.text = "0.1872"
                            370 -> volt.text = "0.1896"
                            380 -> volt.text = "0.1944"
                            390 -> volt.text = "0.1968"
                            400 -> volt.text = "0.1992"
                            410 -> volt.text = "0.2016"
                            420 -> volt.text = "0.204"
                            430 -> volt.text = "0.207"
                            440 -> volt.text = "0.2094"
                            450 -> volt.text = "0.2112"
                            460 -> volt.text = "0.2136"
                            470 -> volt.text = "0.216"
                            480 -> volt.text = "0.219"
                            490 -> volt.text = "0.2214"
                            500 -> volt.text = "0.2232"
                            510 -> volt.text = "0.2244"
                            520 -> volt.text = "0.2262"
                            530 -> volt.text = "0.2286"
                            540 -> volt.text = "0.2316"
                            550 -> volt.text = "0.2346"
                            560 -> volt.text = "0.2358"
                            570 -> volt.text = "0.2367"
                            580 -> volt.text = "0.2382"
                            590 -> volt.text = "0.24"
                            600 -> volt.text = "0.2406"
                            610 -> volt.text = "0.2436"
                            620 -> volt.text = "0.2454"
                            630 -> volt.text = "0.246"
                            640 -> volt.text = "0.2484"
                            650 -> volt.text = "0.2508"
                            660 -> volt.text = "0.2532"
                            670 -> volt.text = "0.2544"
                            680 -> volt.text = "0.2556"
                            690 -> volt.text = "0.2568"
                            700 -> volt.text = "0.258"
                            710 -> volt.text = "0.2598"
                            720 -> volt.text = "0.261"
                            730 -> volt.text = "0.2622"
                            740 -> volt.text = "0.2634"
                            750 -> volt.text = "0.2646"
                            760 -> volt.text = "0.2676"
                            770 -> volt.text = "0.2688"
                            780 -> volt.text = "0.27"
                            790 -> volt.text = "0.2712"
                            800 -> volt.text = "0.2718"
                            810 -> volt.text = "0.273"
                            820 -> volt.text = "0.2736"
                            830 -> volt.text = "0.2739"
                            840 -> volt.text = "0.276"
                            850 -> volt.text = "0.2769"
                            860 -> volt.text = "0.2778"
                            870 -> volt.text = "0.279"
                            880 -> volt.text = "0.2796"
                            890 -> volt.text = "0.2808"
                            900 -> volt.text = "0.282"
                            910 -> volt.text = "0.2826"
                            920 -> volt.text = "0.2832"
                            930 -> volt.text = "0.2838"
                            940 -> volt.text = "0.2844"
                            950 -> volt.text = "0.285"
                            960 -> volt.text = "0.2856"
                            970 -> volt.text = "0.2862"
                            980 -> volt.text = "0.2868"
                            990 -> volt.text = "0.2874"
                            1000 -> volt.text = "0.288"
                            1100 -> volt.text = "0.2826"
                            1200 -> volt.text = "0.276"
                            1300 -> volt.text = "0.27"
                            1400 -> volt.text = "0.261"
                            1500 -> volt.text = "0.2538"
                            1600 -> volt.text = "0.249"
                            1700 -> volt.text = "0.2418"
                            1800 -> volt.text = "0.2364"
                            1900 -> volt.text = "0.2298"
                            2000 -> volt.text = "0.225"
                            2100 -> volt.text = "0.2202"
                            2200 -> volt.text = "0.2154"
                            2300 -> volt.text = "0.21"
                            2400 -> volt.text = "0.2052"
                            2500 -> volt.text = "0.201"
                            2600 -> volt.text = "0.198"
                            2700 -> volt.text = "0.198"
                            2800 -> volt.text = "0.189"
                            2900 -> volt.text = "0.1842"
                            3000 -> volt.text = "0.1818"
                            3100 -> volt.text = "0.1758"
                            3200 -> volt.text = "0.174"
                            3300 -> volt.text = "0.1722"
                            3400 -> volt.text = "0.168"
                            3500 -> volt.text = "0.1662"
                            3600 -> volt.text = "0.1638"
                            3700 -> volt.text = "0.1608"
                            3800 -> volt.text = "0.1572"
                            3900 -> volt.text = "0.1548"
                            4000 -> volt.text = "0.153"
                            4100 -> volt.text = "0.1512"
                            4200 -> volt.text = "0.1488"
                            4300 -> volt.text = "0.147"
                            4400 -> volt.text = "0.1446"
                            4500 -> volt.text = "0.1422"
                            4600 -> volt.text = "0.1398"
                            4700 -> volt.text = "0.138"
                            4800 -> volt.text = "0.1368"
                            4900 -> volt.text = "0.1338"
                            5000 -> volt.text = "0.1326"
                            5100 -> volt.text = "0.132"
                            5200 -> volt.text = "0.129"
                            5300 -> volt.text = "0.1278"
                            5400 -> volt.text = "0.126"
                            5500 -> volt.text = "0.1236"
                            5600 -> volt.text = "0.123"
                            5700 -> volt.text = "0.1218"
                            5800 -> volt.text = "0.12"
                            5900 -> volt.text = "0.1182"
                            6000 -> volt.text = "0.1176"
                            6100 -> volt.text = "0.1164"
                            6200 -> volt.text = "0.1146"
                            6300 -> volt.text = "0.1137"
                            6400 -> volt.text = "0.1128"
                            6500 -> volt.text = "0.111"
                            6600 -> volt.text = "0.1092"
                            6700 -> volt.text = "0.108"
                            6800 -> volt.text = "0.1071"
                            6900 -> volt.text = "0.1056"
                            7000 -> volt.text = "0.105"
                            7100 -> volt.text = "0.1032"
                            7200 -> volt.text = "0.1026"
                            7300 -> volt.text = "0.1014"
                            7400 -> volt.text = "0.1002"
                            7500 -> volt.text = "0.099"
                            7600 -> volt.text = "0.0972"
                            7700 -> volt.text = "0.0966"
                            7800 -> volt.text = "0.0948"
                            7900 -> volt.text = "0.0936"
                            8000 -> volt.text = "0.093"
                            8100 -> volt.text = "0.0918"
                            8200 -> volt.text = "0.0912"
                            8300 -> volt.text = "0.09"
                            8400 -> volt.text = "0.0888"
                            8500 -> volt.text = "0.0879"
                            8600 -> volt.text = "0.087"
                            8700 -> volt.text = "0.0846"
                            8800 -> volt.text = "0.084"
                            8900 -> volt.text = "0.0834"
                            9000 -> volt.text = "0.0828"
                            9100 -> volt.text = "0.0816"
                            9200 -> volt.text = "0.0804"
                            9300 -> volt.text = "0.0801"
                            9400 -> volt.text = "0.0786"
                            9500 -> volt.text = "0.0768"
                            9600 -> volt.text = "0.0756"
                            9700 -> volt.text = "0.0744"
                            9800 -> volt.text = "0.0732"
                            9900 -> volt.text = "0.072"
                            10000 -> volt.text = "0.0714"
                            11000 -> volt.text = "0.063"
                            12000 -> volt.text = "0.0558"
                            13000 -> volt.text = "0.0504"
                            14000 -> volt.text = "0.0474"
                            15000 -> volt.text = "0.0432"
                            16000 -> volt.text = "0.0396"
                            17000 -> volt.text = "0.036"
                            18000 -> volt.text = "0.0336"
                            19000 -> volt.text = "0.0312"
                            20000 -> volt.text = "0.0294"
                            21000 -> volt.text = "0.0276"
                            22000 -> volt.text = "0.0264"
                            23000 -> volt.text = "0.0246"
                            24000 -> volt.text = "0.0234"
                            25000 -> volt.text = "0.0222"
                            26000 -> volt.text = "0.0216"
                            27000 -> volt.text = "0.0198"
                            28000 -> volt.text = "0.0186"
                            29000 -> volt.text = "0.0183"
                            30000 -> volt.text = "0.0174"
                            31000 -> volt.text = "0.0162"
                            32000 -> volt.text = "0.0156"
                            33000 -> volt.text = "0.015"
                            34000 -> volt.text = "0.0141"
                            35000 -> volt.text = "0.0135"
                            36000 -> volt.text = "0.0129"
                            37000 -> volt.text = "0.012"
                            38000 -> volt.text = "0.0114"
                            39000 -> volt.text = "0.0108"
                            40000 -> volt.text = "0.0105"
                            41000 -> volt.text = "0.0102"
                            42000 -> volt.text = "0.0096"
                            43000 -> volt.text = "0.0093"
                            44000 -> volt.text = "0.009"
                            45000 -> volt.text = "0.0087"
                            46000 -> volt.text = "0.0084"
                            47000 -> volt.text = "0.0078"
                            48000 -> volt.text = "0.0075"
                            49000 -> volt.text = "0.0072"
                            50000 -> volt.text = "0.0069"
                            51000 -> volt.text = "0.0066"
                            52000 -> volt.text = "0.0066"
                            53000 -> volt.text = "0.0063"
                            54000 -> volt.text = "0.006"
                            55000 -> volt.text = "0.0057"
                            56000 -> volt.text = "0.00558"
                            57000 -> volt.text = "0.0054"
                            58000 -> volt.text = "0.0051"
                            59000 -> volt.text = "0.0045"
                            60000 -> volt.text = "0.00438"
                            61000 -> volt.text = "0.0042"
                            62000 -> volt.text = "0.0042"
                            63000 -> volt.text = "0.00408"
                            64000 -> volt.text = "0.0039"
                            65000 -> volt.text = "0.0036"
                            66000 -> volt.text = "0.0033"
                            67000 -> volt.text = "0.00318"
                            68000 -> volt.text = "0.003"
                            69000 -> volt.text = "0.0029"
                            70000 -> volt.text = "0.0028"
                            71000 -> volt.text = "0.0027"
                            72000 -> volt.text = "0.00258"
                            73000 -> volt.text = "0.00246"
                            74000 -> volt.text = "0.0024"
                            75000 -> volt.text = "0.00234"
                            76000 -> volt.text = "0.0021"
                            77000 -> volt.text = "0.00198"
                            78000 -> volt.text = "0.0018"
                            79000 -> volt.text = "0.0017"
                            80000 -> volt.text = "0.00169"
                            81000 -> volt.text = "0.00168"
                            82000 -> volt.text = "0.0015"
                            83000 -> volt.text = "0.00138"
                            84000 -> volt.text = "0.0012"
                            85000 -> volt.text = "0.00114"
                            86000 -> volt.text = "0.00108"
                            87000 -> volt.text = "0.0009"
                            88000 -> volt.text = "0.00084"
                            89000 -> volt.text = "0.0078"
                            90000 -> volt.text = "0.00072"
                            91000 -> volt.text = "0.00066"
                            92000 -> volt.text = "0.0006"
                            93000 -> volt.text = "0.00054"
                            94000 -> volt.text = "0.00048"
                            95000 -> volt.text = "0.00042"
                            96000 -> volt.text = "0.0003"
                            97000 -> volt.text = "0.00018"
                            98000 -> volt.text = "0.00012"
                            99000 -> volt.text = "0.00006"
                            100000 -> volt.text = "0"

                            else -> {
                                Toast.makeText(
                                    this@BondPassExperimentHz,
                                    "Invalid Number ",
                                    Toast.LENGTH_LONG
                                ).show()
                                volt.text = "Invalid Number"
                            }
                        }
                    }
                    in 1..10 -> {
                        volt.text = "0"
                    }
                    else -> {
                        Toast.makeText(
                            this@BondPassExperimentHz,
                            "Invalid Number",
                            Toast.LENGTH_LONG

                        ).show()
                        volt.text = "Invalid Number"
                    }
                }

            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun nextPageMethod() {
        btn_nextPage.setOnClickListener {
            val intent = Intent(this@BondPassExperimentHz, BondPassChart::class.java)
            startActivity(intent)
        }
    }

}
