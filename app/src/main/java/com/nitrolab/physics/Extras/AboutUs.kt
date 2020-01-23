package com.nitrolab.physics.Extras

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nitrolab.physics.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        clickListener()
        adsBanner()

    }

    private fun adsBanner() {

        MobileAds.initialize(
            this
        ) { }
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        val adView = AdView(this)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-4454440016331822/9209220507"

        // for test: ca-app-pub-3940256099942544/6300978111
    }

    private fun clickListener() {

        abazaEmail.setOnClickListener {
            try {
                val sendEmail = Intent(Intent.ACTION_SEND)
                sendEmail.data = Uri.parse("mailto:") //const code for send email
                sendEmail.type = "message/rfc822"   //const code for send email
                sendEmail.putExtra(Intent.EXTRA_EMAIL, "abaza.jobs@gmail.com")
                sendEmail.putExtra(Intent.EXTRA_TEXT, "")
                startActivity(sendEmail)
            } catch (e: Exception) {
                Toast.makeText(
                    this@AboutUs,
                    "Thire is no mail apps on you phone",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        abazaFacebook.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/M7mdAbaza96")
            )
            startActivity(intent)
        }

        abazaInstgram.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/m7md_abaza/")
            )
            startActivity(intent)
        }

        abdullahFacebook.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/profile.php?id=100007262537691")
            )
            startActivity(intent)
        }

    }


}
