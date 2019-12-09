package com.nitrolab.physics.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nitrolab.physics.FourthYearExperiments.BondPassExperimentHz
import com.nitrolab.physics.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_fourth_year.view.*

class FourthYearFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_fourth_year, container, false)

        /***********************************/
        inflate.experimentPDF.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://drive.google.com/open?id=1GpZ7eQZsUG73RJa_6cubmFTAeRlZOyXy")
            )
            startActivity(intent)
        }
        inflate.experimentVideo.setOnClickListener {
            Toast.makeText(
                context,
                "الفيديوهات سيكون متاحة في النسخة الرسمية",
                Toast.LENGTH_LONG
            ).show()
        }
        inflate.experimentPractice.setOnClickListener {
            val intent = Intent(context, BondPassExperimentHz::class.java)
            startActivity(intent)
        }
        /***********************************/
        MobileAds.initialize(context) { }
        val adRequest = AdRequest.Builder().build()
        inflate.adView.loadAd(adRequest)
        val adView = AdView(context)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        // for test: ca-app-pub-3940256099942544/6300978111

        /***********************************/

        return inflate
    }

}