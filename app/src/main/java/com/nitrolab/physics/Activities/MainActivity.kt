package com.nitrolab.physics.Activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nitrolab.physics.Adapters.FragmentsAdapter
import com.nitrolab.physics.Extras.AboutUs
import com.nitrolab.physics.Extras.SupportUs
import com.nitrolab.physics.R
import com.google.android.material.tabs.TabLayout.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ifInternetAvailable()
        handelToolbar()
        handelTableLayout()



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle item selection
        return when (item.itemId) {
            R.id.menu_main_aboutUs -> {
                val intent = Intent(this, AboutUs::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_main_support_us -> {
                val intent = Intent(this, SupportUs::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
         menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun handelToolbar() {
        toolbar.title = "Nitro Lab"
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)

        // المفروض السطرين دول يتنقلو مع handelTableLayout()
        val adapter = FragmentsAdapter(supportFragmentManager)
        viewPager.adapter = adapter

    }

    private fun handelTableLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("1st Year"))
        tabLayout.addTab(tabLayout.newTab().setText("2nd Year"))
        tabLayout.addTab(tabLayout.newTab().setText("3rd Year"))
        tabLayout.addTab(tabLayout.newTab().setText("4th Year"))

        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#D81B60"))


        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        viewPager.currentItem = 3
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: Tab) {}
            override fun onTabReselected(tab: Tab) {}
        })
    }

    // This IfInternetAvailable() to display Views if there is internet
    private fun ifInternetAvailable() {
        progressBar.visibility = View.VISIBLE
        if (checkConnectivity()) {
            progressBar.visibility = View.GONE
            noInternet.visibility = View.GONE
            tabLayout.visibility = View.VISIBLE
            viewPager.visibility = View.VISIBLE
        } else
        // if no internet
        {
            progressBar.visibility = View.GONE
            noInternet.visibility = View.VISIBLE
            tabLayout.visibility = View.INVISIBLE
            viewPager.visibility = View.INVISIBLE
        }
        // for try to check internet again
        noInternet.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            if (checkConnectivity()) {
                progressBar.visibility = View.GONE
                noInternet.visibility = View.GONE
                tabLayout.visibility = View.VISIBLE
                viewPager.visibility = View.VISIBLE
            } else
            // if no internet
            {
                progressBar.visibility = View.GONE
                noInternet.visibility = View.VISIBLE
                tabLayout.visibility = View.INVISIBLE
                viewPager.visibility = View.INVISIBLE
            }
        }

    }

    // This checkConnectivity() for Check if third is internet or not
    private fun checkConnectivity(): Boolean {
        //boolean enabled = true;

        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.run {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                    if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true
                    } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true
                    }
                }
            }
        }
        return false

    }
}