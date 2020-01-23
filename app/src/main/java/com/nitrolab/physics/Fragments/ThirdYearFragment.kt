package com.nitrolab.physics.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.nitrolab.physics.Adapters.ThirdExperimentAdapter
import com.nitrolab.physics.Models.PdfModel
import com.nitrolab.physics.Models.VideoModel
import com.nitrolab.physics.Models.YearExperimentModel
import com.nitrolab.physics.R
import kotlinx.android.synthetic.main.fragment_fourth_year.view.*
import java.util.ArrayList

class ThirdYearFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_year, container, false)


        val videoValue = ArrayList<VideoModel>()

        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))
        videoValue.add(VideoModel("https://youtube.com/"))

        /***************************************/
        val pdfValue = ArrayList<PdfModel>()

        pdfValue.add(PdfModel("https://stackoverflow.com/questions/47865436/cant-set-visibility-on-constraint-group"))
        pdfValue.add(PdfModel("https://www.google.com/"))
        pdfValue.add(PdfModel("https://www.facebook.com/"))
        pdfValue.add(PdfModel("https://github.com/"))
        pdfValue.add(PdfModel("https://www.linkedin.com/feed/"))
        pdfValue.add(PdfModel("https://www.linkedin.com/feed/"))
        pdfValue.add(PdfModel("https://www.linkedin.com/feed/"))

        /*************************************/
        val value = ArrayList<YearExperimentModel>()

        value.add(YearExperimentModel("NTC"))
        value.add(YearExperimentModel("AC Circuit With A Capacitor"))
        value.add(YearExperimentModel("AC Circuit With A Coil"))
        value.add(YearExperimentModel("Transistor Part(A)"))
        value.add(YearExperimentModel("Transistor Part(B)"))
        value.add(YearExperimentModel("Laser"))
        value.add(YearExperimentModel("Solar Cell"))

        val recyclerView = view?.rootView?.findViewById<RecyclerView>(R.id.recycle_thirdYear)

        recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = ThirdExperimentAdapter(value,pdfValue,videoValue,requireActivity())
        recyclerView?.adapter = adapter

        /*************************************/
        MobileAds.initialize(context) { }
        val adRequest = AdRequest.Builder().build()
        view.adView.loadAd(adRequest)
        val adView = AdView(context)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        // for test Ads: ca-app-pub-3940256099942544/6300978111

        /***********************************/

        return view
    }


}