package com.nitrolab.physics.Extras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nitrolab.physics.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
import kotlinx.android.synthetic.main.activity_support_us.*

class SupportUs : AppCompatActivity() {
    private lateinit var mPublisherInterstitialAd: PublisherInterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_us)

        adsBanner()
        interstitialAd()

    }

    private fun interstitialAd() {

        mPublisherInterstitialAd = PublisherInterstitialAd(this)
        mPublisherInterstitialAd.adUnitId = "/6499/example/interstitial"
        //ca-app-pub-4454440016331822/3579088489
        mPublisherInterstitialAd.loadAd(PublisherAdRequest.Builder().build())

        watchAdBtn.setOnClickListener {
            if (mPublisherInterstitialAd.isLoaded) {
                mPublisherInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
        }


        mPublisherInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                mPublisherInterstitialAd.loadAd(PublisherAdRequest.Builder().build())

            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mPublisherInterstitialAd.loadAd(PublisherAdRequest.Builder().build())

            }
        }

    }

    private fun adsBanner() {

        MobileAds.initialize(
            this
        ) { }

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        val adView = AdView(this)
        adView.adSize = AdSize.SMART_BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        // for test: ca-app-pub-3940256099942544/6300978111
    }
}
